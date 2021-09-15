package co.vinod.training.entity;

public interface Camera {
    void takePhoto();

    // the  keyword "default" was introduced in java 8, and should be considered for code re-usability
    default void play(){
        System.out.println("default play feature");
    }
}
