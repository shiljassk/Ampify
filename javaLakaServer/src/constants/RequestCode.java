package constants;

public enum RequestCode {
    LOGIN_REQUEST,
    SIGNUP_REQUEST,
    USER_EMAIL_VALIDATION,
    GET_SONGLIST,
    GET_SONG,
    HISTORY_REQUEST,
    GET_PLAYLISTS,
    CREATE_PLAYLIST,
    NEW_SONGS,
    SEARCH_SONG,
    CREATE_GROUP,
    ADD_SONG_TO_PLAYLIST,
    RECOMMENDATION,
    TRENDING,
    SYNCHRONIZATION,
    SEND_FEEDBACK,
    GET_FEEDBACK,
    USER_SEARCH,
    GET_STATUS,
    LOGOUT_REQUEST;
    
    RequestCode(){
        this.toString();
    }
}
