package Teams;

public class Main {
    public static void main(String[] args){

        Courses c = new Courses(12.0,20.0,5.0); //создание полосы препятствий
        c.Info(); //информация о полосе препятствий
        Team team = new Team("медузы"); //сохдание команды
        team.Info(); // информация о команде
        c.DoIT(team); // запрос пройти команде полосу препятствий
        team.InfoResults(); // вывод результатов
    }
}
