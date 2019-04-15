package Teams;



public class Courses {
    private Double LengthSwimming;
    private Double LengthRunning;
    private Double HeightJumping;



    public  Courses(Double LengthSwimming, Double LengthRunning, Double HeightJumping){
        this.LengthSwimming=LengthSwimming;
        this.LengthRunning=LengthRunning;
        this.HeightJumping=HeightJumping;
    }

    public void Info(){
        System.out.println("===========Полоса Препятствий===========");
        System.out.println("Протяженность полосы для плавания:"+this.LengthSwimming);
        System.out.println("Протяженность полосы для бега:"+this.LengthRunning);
        System.out.println("Высота препятствия для прыжка:"+this.HeightJumping);
    }
    public void DoIT(Team Team){

            Team.Results(this.LengthSwimming,this.LengthRunning,this.HeightJumping);
    }

}
