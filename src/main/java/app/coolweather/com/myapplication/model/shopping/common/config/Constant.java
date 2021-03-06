package app.coolweather.com.myapplication.model.shopping.common.config;

import android.annotation.SuppressLint;

@SuppressLint("SdCardPath")
public class Constant {

    /** Intent传递Bean的KEY */
    public static final String KEY_INTENT_BEAN = "bean";

    /** 响应结果，正确 */
    public static final int RESULT_SUCCESS = 0;

    /** 登录已过期 */
    public static final String RESULT_LOGIN_OUT_OF_DATE = "55";

    /** 授权令牌的KEY */
    public static final String RESULT_KEY_ACCESS_TOKEN = "authToken";

    public static final String RESULT_KEY = "errCode";

    public static final String RESULT_MESSAGE_KEY = "errInfo";

    public static final String RESULT_CONTENT = "entity";

    public static final String RESULT_KEY_ENTITY = "entity";

    public static final String RESULT_KEY_PAGE_ENTITY = "pageEntity";

    public static final String RESULT_KEY_QINIU_TOKEN = "uptoken";

    /** 网络错误 */
    public static final String TEXT_ERROR_500 = "网络错误500";

    /** 网络错误500 */
    public static final int STATUS_NET_ERROR = 500;

    /** 500的提示 */
    public static final String JSON500 = "网络连接不稳定";

    /** 更新标示 **/
    public static final int UPDATE_SERVICE = 3;

    public static final String IMAGE_SPLITE = "##";

    public static final String CHAR_REPLACE = "$s$";

    public static final String LOADING = "正在加载，请稍后...";

    /** 有效 */
    public static final String STATE_VALID = "0";

    /** 无效 */
    public static final String STATE_INVALID = "1";

    /** DES 加密key值 */
    public static final String DES_KEY = "abcdefgh";

    public static final String IMAGE_PATH = "/wxt";

    public static int SCREEN_WIDTH = 0;

    public static int PAGE_SIZE_DEFAULLT = 7;
    public static int PAGE_NO_DEFAULT = 1;
    /*--------------------------------SP Key------------------------------------*/

    /** SharedPreferences的key */
    public static final String SP_NAME_PROJECT = "FatTail";
    /** UMeng推送的key */
    public static final String SP_KEY_PUSH = "push";
    public static final String SP_KEY_OWER_ID = "owerID";
    public static final String SP_KEY_COMMUNITY_ID = "communityID";

    /** 服务器返回的错误信息 */
    public static final int WHAT_ERROR_HTTP = 500;

    /** accessToken过期 */
    public static final int WHAT_TOKEN_EXPIRED = 1011;

    /** 忘记密码 */
    public static final int WHAT_FORGET = 100;

    /** 请求短信验证码 */
    public static final int WHAT_VALIDATION_CODE = 101;

    /** 倒计时 */
    public static final int WHAT_COUNT_DOWN = 102;

    /** 登录 */
    public static final int WHAT_LOGIN = 103;

    /** 评论列表 */
    public static final int WHAT_COMMENT_LIST = 104;

    /** 双击退出 */
    public static final int WHAT_EXIT = 105;

}
