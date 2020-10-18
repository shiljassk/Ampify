package main;

import authenticationHandler.Login;
import authenticationHandler.SignUp;
import authenticationHandler.Validation;
import constants.RequestCode;
import constants.ResponseCode;
import data.User;
import feedbackHandler.FeedbackResponse;
import feedbackHandler.GetFeedbackHandler;
import feedbackHandler.SendFeedbackHandler;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import request.AddSongToPlaylistRequest;
import request.CreatePlaylistRequest;
import request.GetFeedbackRequest;
import request.GetPlaylistRequest;
import request.GetStatusRequest;
import request.SongRequest;
import request.HistoryRequest;
import request.LogOutRequest;
import request.LoginRequest;
import request.NewSongsRequest;
import request.RecommendationRequest;
import request.Request;
import request.Response;
import request.SearchSongRequest;
import request.SendFeedbackRequest;
import request.SignUpRequest;
import request.TrendingRequest;
import request.UserSearchRequest;
import request.ValidityRequest;
import requestHandler.AddSongToPlaylist;
import requestHandler.CreatePlaylistHandler;
import requestHandler.HistoryHandler;
import requestHandler.NewSongsHandler;
import requestHandler.PlaylistNameHandler;
import requestHandler.RecommendationHandler;
import requestHandler.SearchSongHandler;
import requestHandler.SongListHandler;
import requestHandler.SongHandler;
import requestHandler.TrendingSongsHandler;
import requestHandler.UserSearchHandler;
import statusHandler.MakeUserOffline;
import statusHandler.MakeUserOnline;
import statusHandler.StatusResponse;
import statusHandler.UserStatusHandler;

public class handleClientRequest implements Runnable{
    private final Socket socket;
    ObjectOutputStream oos;
    ObjectInputStream ois ;
    
    
    public handleClientRequest(Socket socket) throws IOException{
        this.socket=socket;
        oos = new ObjectOutputStream(socket.getOutputStream());
        ois = new ObjectInputStream(socket.getInputStream());
    }
    
    @Override
    public void run(){
        Request request = null;
        
        while(true){
            try{
                Object o= ois.readObject();
                System.out.println(o.getClass());
                request = (Request) o;
                
            } catch (IOException | ClassNotFoundException a ) {
                System.out.println("CLIENT DISCONNECTED");
            return;
            } 
            
            if(request.getRequestCode().equals(RequestCode.SIGNUP_REQUEST)){
                SignUp signUp = new SignUp((SignUpRequest) request);
                Response response = signUp.getResponse();
                if(response.getResponseCode().equals(ResponseCode.SUCCESSFUL)){
                    new MakeUserOnline((User) response.getResponseObject());
                }
                try{
                    oos.writeObject(response);
                    oos.flush();
                }catch (IOException e){}
            }
            
            else if(request.getRequestCode().equals(RequestCode.USER_EMAIL_VALIDATION)){
                Validation validation = new Validation((ValidityRequest) request);
                Response response = validation.getResponse();
                try{
                    oos.writeObject(response);
                    oos.flush();
                }catch(IOException e){}
            }
                
            else if(request.getRequestCode().equals(RequestCode.LOGIN_REQUEST)) {
                Login login = new Login((LoginRequest) request);
                Response response = login.getResponse();
                if(response.getResponseCode().equals(ResponseCode.SUCCESSFUL)){
                    new MakeUserOnline((User) response.getResponseObject());
                }
                try {
                    oos.writeObject(response);
                    oos.flush();
                } catch (IOException ex) {}    
            }
            
            else if(request.getRequestCode().equals(RequestCode.LOGOUT_REQUEST)) {
                new MakeUserOffline((LogOutRequest) request);
            }
            
            else if(request.getRequestCode().equals(RequestCode.GET_SONGLIST)){
                SongListHandler songSender = new SongListHandler();
                Response response = songSender.getResponse();
                try{
                    oos.writeObject(response);
                    oos.flush();
                } catch(IOException e) {}
            }
            
            else if(request.getRequestCode().equals(RequestCode.HISTORY_REQUEST)){
                HistoryHandler historyHandler = new HistoryHandler((HistoryRequest) request);
                Response response = historyHandler.getResponse();
                try{
                    oos.writeObject(response);
                    oos.flush();
                } catch(IOException e) {}
            }
            
            else if(request.getRequestCode().equals(RequestCode.GET_SONG)){
                SongHandler songHandler = new SongHandler((SongRequest) request);
                Response response = songHandler.getResponse();
                try{
                    oos.writeObject(response);
                    oos.flush();
                } catch(IOException e) {}
            }
            
            else if(request.getRequestCode().equals(RequestCode.GET_PLAYLISTS)){
                PlaylistNameHandler playlistNameHandler = new PlaylistNameHandler((GetPlaylistRequest)request);
                Response response = playlistNameHandler.getResponse();
                try{
                    oos.writeObject(response);
                    oos.flush();
                } catch(IOException e) {}
            }
            
            else if(request.getRequestCode().equals(RequestCode.CREATE_PLAYLIST)){
                CreatePlaylistHandler createPlaylistHandler = new CreatePlaylistHandler((CreatePlaylistRequest) request);
                Response response = createPlaylistHandler.getResponse();
                try{
                    oos.writeObject(response);
                    oos.flush();
                } catch(IOException e) {}
            }
            
            else if(request.getRequestCode().equals(RequestCode.NEW_SONGS)){
                NewSongsHandler newSongsHandler = new NewSongsHandler((NewSongsRequest) request);
                Response response = newSongsHandler.getResponse();
                try{
                    oos.writeObject(response);
                    oos.flush();
                } catch(IOException e) {}
            }
            
            else if(request.getRequestCode().equals(RequestCode.SEARCH_SONG)){
                SearchSongHandler searchSongHandler = new SearchSongHandler((SearchSongRequest) request);
                Response response = searchSongHandler.getResponse();
                try{
                    oos.writeObject(response);
                    oos.flush();
                } catch(IOException e) {}
            }
            
            else if(request.getRequestCode().equals(RequestCode.USER_SEARCH)){
                UserSearchHandler userSearchHandler = new UserSearchHandler((UserSearchRequest) request);
                Response response = userSearchHandler.getResponse();
                try{
                    oos.writeObject(response);
                    oos.flush();
                } catch(IOException e) {}
            }
            
            else if(request.getRequestCode().equals(RequestCode.GET_STATUS)){
                UserStatusHandler userStatusHandler = new UserStatusHandler((GetStatusRequest) request);
                StatusResponse statusResponse = userStatusHandler.getResponse();
                try{
                    oos.writeObject(statusResponse);
                    oos.flush();
                } catch(IOException e) {}
            }
            
            else if(request.getRequestCode().equals(RequestCode.ADD_SONG_TO_PLAYLIST)){
                AddSongToPlaylist addSongToPlaylist = new AddSongToPlaylist((AddSongToPlaylistRequest) request);
                Response response = addSongToPlaylist.getResponse();
                try{
                    oos.writeObject(response);
                    oos.flush();
                } catch(IOException e) {}
            }
            
            else if(request.getRequestCode().equals(RequestCode.ADD_SONG_TO_PLAYLIST)){
                RecommendationHandler recommendationHandler = new RecommendationHandler((RecommendationRequest) request);
                Response response = recommendationHandler.getResponse();
                try{
                    oos.writeObject(response);
                    oos.flush();
                } catch(IOException e) {}
            }
            
            else if(request.getRequestCode().equals(RequestCode.ADD_SONG_TO_PLAYLIST)){
                TrendingSongsHandler trendingSongsHandler = new TrendingSongsHandler((TrendingRequest) request);
                Response response = trendingSongsHandler.getResponse();
                try{
                    oos.writeObject(response);
                    oos.flush();
                } catch(IOException e) {}
            }
            
            else if(request.getRequestCode().equals(RequestCode.SEND_FEEDBACK)){
                new SendFeedbackHandler((SendFeedbackRequest) request);
            }
            
            else if(request.getRequestCode().equals(RequestCode.SEND_FEEDBACK)){
                GetFeedbackHandler getFeedbackHandler = new GetFeedbackHandler((GetFeedbackRequest) request);
                FeedbackResponse feedbackresponse = getFeedbackHandler.getFeedbackResponse();
                try{
                    oos.writeObject(feedbackresponse);
                    oos.flush();
                } catch(IOException e) {}
            }
            
            
    }
}
}
