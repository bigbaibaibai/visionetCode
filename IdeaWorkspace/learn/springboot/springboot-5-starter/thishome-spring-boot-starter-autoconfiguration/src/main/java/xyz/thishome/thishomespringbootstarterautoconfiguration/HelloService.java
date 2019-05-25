package xyz.thishome.thishomespringbootstarterautoconfiguration;

public class HelloService {

    private HelloProperties helloProperties;

    public void sayHello(String name) {
        System.out.println(helloProperties.getProfix() + "--" + name + "--" + helloProperties.getSuffix());
    }

    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }
}
