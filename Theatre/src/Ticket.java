public class Ticket {
    Person person;
    int row,seat;
    double price;
    public Ticket(int row,int seat,double price,Person person){
        this.person=person;
        this.row=row;
        this.seat=seat;
        this.price=price;
    }
    public void print(){
        System.out.println("Name  : "+person.name+" "+ person.surname);
        System.out.println("Email : "+person.email);
        System.out.println("Row   : "+row);
        System.out.println("Seat  : "+seat);
        System.out.println("Price : "+price);
    }
    public double getPrice() {return price;}
}
