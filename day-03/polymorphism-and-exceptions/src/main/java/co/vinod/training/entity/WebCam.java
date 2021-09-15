package co.vinod.training.entity;

public class WebCam implements Camera{
    @Override
    public void takePhoto() {
        System.out.println("Taking a picture using web camera");
    }
}
