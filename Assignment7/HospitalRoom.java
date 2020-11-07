package Assignment7;

public class HospitalRoom {
    //TODO: implement your code here
    private final int maxDoc = 1, maxPat = 3;
    private int numOfDoc = 0, numOfPat = 0;
    private final Object LOCKDOC = new Object();
    private final Object LOCKPAT = new Object();

    public boolean doctorEnter(Doctor d) throws InterruptedException {
        //TODO: implement your code here
        synchronized (LOCKDOC) {
                if (numOfDoc == maxDoc) {
                    System.out.println("Doctor " + d.name + " is waiting to Enter, number of doctor " + maxDoc);
                    LOCKDOC.wait();
                    return false;
                } else {
                    numOfDoc++;
                    System.out.println("Doctor " + d.name + " Entered, number of doctor " + numOfDoc);
                    Thread.sleep(500);
                    LOCKDOC.notify();
                    return true;
                }
        }
    }

    public boolean doctorLeave(Doctor d) throws InterruptedException {
        //TODO: implement your code here
        synchronized (LOCKDOC) {
                if (numOfDoc == 0) {
                    LOCKDOC.wait();
                    return false;
                } else {
                    numOfDoc--;
                    System.out.println("Doctor " + d.name + " Left, number of doctor " + numOfDoc);
                    Thread.sleep(500);
                    LOCKDOC.notify();
                    return true;
                }
        }
    }

    public boolean patientEnter(Patient p) throws InterruptedException {
        //TODO: implement your code here
        synchronized (LOCKPAT) {
                if (numOfPat == maxPat) {
                    System.out.println("Patient " + p.name + " is waiting to Enter, number of patients " + maxPat);
                    LOCKPAT.wait();
                    return false;
                } else {
                    numOfPat++;
                    System.out.println("Patient " + p.name + " Entered, number of patients " + numOfPat);
                    Thread.sleep(500);
                    LOCKPAT.notify();
                    return true;
                }
        }
    }

    public boolean patientLeave(Patient p) throws InterruptedException {
        //TODO: implement your code here
        synchronized (LOCKPAT) {
                if (numOfPat == 0) {
                    LOCKPAT.wait();
                    return false;
                } else {
                    numOfPat--;
                    System.out.println("Patient " + p.name + " Left");
                    Thread.sleep(500);
                    LOCKPAT.notify();
                    return true;
                }
        }
    }
}

class Doctor {
    public String name;
    public Doctor(String name) {
        this.name = name;
    }
}

class Patient {
    public String name;
    public Patient(String name) {
        this.name = name;
    }
}


class Main2 {
    public static void main(String[] args) {
        HospitalRoom room = new HospitalRoom();
        Doctor siva = new Doctor("siva");
        Doctor john = new Doctor("john");
        Patient p1 = new Patient("p1");
        Patient p2 = new Patient("p2");
        Patient p3= new Patient("p3");
        Patient p4 = new Patient("p4");
        Patient p5 = new Patient("p5");
        Thread doctor1 = new Thread(() -> {
            try {
                while(!room.doctorEnter(siva)) {}
                Thread.sleep(500);
                while(!room.doctorLeave(siva)) {}

            } catch (InterruptedException e) {
                e.printStackTrace();
            //} catch (IllegalMonitorStateException e) {
            }
        });

        Thread doctor2 = new Thread(() -> {
            try {
                while(!room.doctorEnter(john)) {}
                Thread.sleep(500);
                while(!room.doctorLeave(john)) {}
            } catch (InterruptedException e) {
                e.printStackTrace();
            //}catch (IllegalMonitorStateException e) {
            }
        });

        Thread patient1 = new Thread(() -> {
            try {
                while(!room.patientEnter(p1)) {}
                Thread.sleep(500);
                while(!room.patientLeave(p1)) {}
            } catch (InterruptedException e) {
                e.printStackTrace();
           // }catch (IllegalMonitorStateException e) {
            }
        });

        Thread patient2 = new Thread(() -> {
            try {
                while(!room.patientEnter(p2)) {};
                Thread.sleep(500);
                while(!room.patientLeave(p2)) {};
            } catch (InterruptedException e) {
                e.printStackTrace();
            //}catch (IllegalMonitorStateException e) {
            }
        });

        Thread patient3 = new Thread(() -> {
            try {
                while(!room.patientEnter(p3)) {};
                Thread.sleep(500);
                while(!room.patientLeave(p3)) {};
            } catch (InterruptedException e) {
                e.printStackTrace();
            //}catch (IllegalMonitorStateException e) {
            }
        });

        Thread patient4 = new Thread(() -> {
            try {
                while(!room.patientEnter(p4)) {};
                Thread.sleep(500);
                while(!room.patientLeave(p4)) {};
            } catch (InterruptedException e) {
                e.printStackTrace();
            //}catch (IllegalMonitorStateException e) {
            }
        });

        Thread patient5 = new Thread(() -> {
            try {
                while(!room.patientEnter(p5)) {};
                Thread.sleep(500);
                while(!room.patientLeave(p5)) {};
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        doctor1.start();
        doctor2.start();
        patient1.start();
        patient2.start();
        patient3.start();
        patient4.start();
        patient5.start();
    }
}
