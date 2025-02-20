package vn.iotstar.api.bai2ioc;

public class HelloWord {
    private String message;
    public void setMessage(String message) {
        this.message = message;
    }
    public void getMessage() {
        System.out.println("My Message : " + message);
    }

}
