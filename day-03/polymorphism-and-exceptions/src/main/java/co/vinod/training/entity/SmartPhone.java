package co.vinod.training.entity;

public class SmartPhone extends Phone implements Camera, MusicPlayer{
    public void addContact(){
        System.out.println("Adding a new contact..");
    }

    @Override
    public void takePhoto() {
        System.out.println("Taking a picture using smartphone...");
    }

    @Override
    public void play() {
        System.out.println("Plaing music");
    }



    @Override
    public void pause() {
        System.out.println("Musing paused");
    }
}
