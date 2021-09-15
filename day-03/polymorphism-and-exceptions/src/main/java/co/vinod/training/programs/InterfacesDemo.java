package co.vinod.training.programs;

import co.vinod.training.entity.Camera;
import co.vinod.training.entity.SmartPhone;
import co.vinod.training.entity.WebCam;

public class InterfacesDemo {

    static void processCamera(Camera camera){
        camera.takePhoto();
        camera.play();
    }

    public static void main(String[] args) {

        WebCam wc = new WebCam();
        SmartPhone sp = new SmartPhone();

        processCamera(wc);
        processCamera(sp);
    }
}
