package Teams;

public class Members {
    private String Surname;
    private double LengthSwimming;
    private double LengthRunning;
    private double HeightJumping;

    private String SwimmingResult;
    private String RunningResult;
    private String JumpingResult;



    public Members(String Surname,double LengthSwimming, double LengthRunning, double HeightJumping){

        this.Surname=Surname;
        this.LengthSwimming=LengthSwimming;
        this.LengthRunning=LengthRunning;
        this.HeightJumping=HeightJumping;
    }
    void InfoMember(){
        System.out.println("Фамилия участника: "+this.Surname);
        System.out.println("Плавание: "+this.LengthSwimming);
        System.out.println("Бег: "+this.LengthRunning);
        System.out.println("Прыжок: "+this.HeightJumping);
    }
    void Result(double LengthSwimming,double LengthRunning, double HeightJumping){
        // Результат плавания

            if(this.LengthSwimming>=LengthSwimming){
                this.SwimmingResult="Плавание пройдено!";
            }else {
                this.SwimmingResult="Плавание провалено!";
            }
            // Результат бега
            if(this.LengthRunning>=LengthRunning){
                this.RunningResult="Бег пройден!";
            }else {
                this.RunningResult="Бег провален!";
            }
            // Результат прыжка
            if(this.HeightJumping>=HeightJumping){
                this.JumpingResult="Прыжок пройдено!";
            }else {
                this.JumpingResult="Прыжок провалено!";
            }
    }
   void InfoResult(){
       System.out.println("Результаты участника: "+this.Surname);
       System.out.println("Плавание: "+this.SwimmingResult);
       System.out.println("Бег: "+this.RunningResult);
       System.out.println("Прыжок: "+this.JumpingResult);

    }
}



