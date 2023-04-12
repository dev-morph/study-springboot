package hello.core.singleton;

public class SingletonService {
    //자바가 뜰 때 SingletonService가 생성되서 instacne에 참조 값이 저장된다. 
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getinstance(){
        return instance;
    }

    private SingletonService(){}

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
