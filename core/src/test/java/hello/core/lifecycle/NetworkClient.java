package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient implements InitializingBean, DisposableBean{
    private String url;

    public NetworkClient(){
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url){
        this.url = url;
    }

    public void connect(){
        System.out.println("connect: " + url);
    }
    
    public void call(String message){
        System.out.println("call: " + url + " message = " + message);
    }

    public void disconnect(){
        System.out.println("close " + url);
    }

    // 해당 메소드는 빈이 생성자를 통해 생성이 되고, 
    // 모든 Properties가 set이 된 이후에 호출 되게 된다.
    @Override
    public void afterPropertiesSet() throws Exception {
        connect();
        call("초기화 연결 메시지");
    } 

    @Override
    public void destroy() throws Exception {
        disconnect();
    }
}
