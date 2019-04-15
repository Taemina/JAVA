package Teams;

public class Team {
    private String NameTeam;
    private Members[] Member;

    public Team(String NameTeam){
        this.NameTeam=NameTeam;
        this.Member=new Members[4];
        this.Member[0] = new Members("Первый",23.0,30.0,4);
        this.Member[1] = new Members("Второй",13.0,29.0,6);
        this.Member[2] = new Members("Третий",5.0,3.0,3);
        this.Member[3] = new Members("Четвертый",30.0,10.0,8);


    }
    void Info(){
        System.out.println("===========Команда===========");
        System.out.println("Название команды: "+this.NameTeam);
        for(int i=0;i<4;i++) {
            Member[i].InfoMember();
        }
    }
    void InfoResults(){
        System.out.println("===========Результаты команды ===========");
        for(int i=0;i<4;i++) {
            System.out.println("====================================");
            Member[i].InfoResult();
        }
    }
    void Results(double LengthSwimming,double LengthRunning, double HeightJumping){
        for(int i=0;i<4;i++) {
            Member[i].Result(LengthSwimming,LengthRunning, HeightJumping);
        }
    }
}
