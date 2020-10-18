/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constants;

/**
 *
 * @author rishi
 */
public enum RequestCode {
    LOGIN_REQUEST,
    SIGNUP_REQUEST,
    GETMUSIC_REQUEST,
    HISTORY_REQUEST,
    GETPLAYLIST_REQUEST,
    CREATEPLAYLIST_REQUEST,
    NEWSONGS_REQUEST,
    FILEDOWNLOAD_REQUEST,
    SEARCHMUSIC_REQUEST,
    CREATEGROUP_REQUEST,
    ADDSONGTOPLAYLIST_REQUEST,
    RECOMMENDATION_REQUEST,
    TRENDING_REQUEST,
    NOTIFICATION_REQUEST,
    LOGOUT_REQUEST,
    FEEDBACK_REQUEST,
    GETSTATUS_REQUEST,
    SHAREABLEPLAYLIST_REQUEST,
    USERSEARCH_REQUEST,
    USERIP_REQUEST;
    
    RequestCode(){
        this.toString();
    }
    
}
