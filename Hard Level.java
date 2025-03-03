import java.util.concurrent.locks.ReentrantLock;
class TicketBookingSystem {
 private int availableSeats = 5;
 private final ReentrantLock lock = new ReentrantLock(true); // Fair lock
 public void bookTicket(String passenger, int seats) {
 lock.lock();
 try {
 if (seats <= availableSeats) {
 System.out.println(passenger + " successfully booked " + seats + " seat(s).");
 availableSeats -= seats;
} else {
   System.out.println(passenger + " failed to book. Not enough seats.");
   }
   } finally {
   lock.unlock();
   }
   }
  }
  class Passenger extends Thread {
   private TicketBookingSystem system;
   private String passengerName;
   private int seats;
   public Passenger(TicketBookingSystem system, String passengerName, int seats, int priority) {
   this.system = system;
   this.passengerName = passengerName;
   this.seats = seats;
   this.setPriority(priority);
   }
   public void run() {
   system.bookTicket(passengerName, seats);
   }
  }
  public class TicketBookingApp {
   public static void main(String[] args) {
   TicketBookingSystem system = new TicketBookingSystem();
   Passenger p1 = new Passenger(system, "VIP-1", 2, Thread.MAX_PRIORITY);
   Passenger p2 = new Passenger(system, "User-1", 1, Thread.NORM_PRIORITY);
   Passenger p3 = new Passenger(system, "VIP-2", 1, Thread.MAX_PRIORITY);
 Passenger p4 = new Passenger(system, "User-2", 2, Thread.NORM_PRIORITY);
 Passenger p5 = new Passenger(system, "User-3", 1, Thread.NORM_PRIORITY);
 p1.start();
 p2.start();
 p3.start();
 p4.start();
 p5.start();
 }
}
