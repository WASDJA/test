package cn.zhku.zto;

import java.io.Serializable;

/**
 * @ClassName: CallbackEntity
 * @Description: 回调接口返回信息实体
 */
public class CallbackEntity implements Serializable {

    /**
     * @fieldName: serialVersionUID
     * @fieldType: long
     * @Description: 序列化
     */
    private static final long serialVersionUID = 1L;
    //返回信息
    private String message;
    //返回结果标识
    private String result;
    //返回成功状态
    private boolean status;
    //返回成功编码
    private String statusCode;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

}

