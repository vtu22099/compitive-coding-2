import java.util.*; 
 
class Patient { 
    int id; 
    int severity; 
    int treatmentTime; 
 
    Patient(int id, int severity, int treatmentTime) { 
        this.id = id; 
        this.severity = severity; 
        this.treatmentTime = treatmentTime; 
    } 
} 
 
public class HospitalScheduling { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
 
        System.out.print("Enter number of patients: "); 
        int n = sc.nextInt(); 
 
        System.out.print("Enter number of doctors: "); 
        int numDoctors = sc.nextInt(); 
 
        List<Patient> patients = new ArrayList<>(); 
        for (int i = 0; i < n; i++) { 
            System.out.println("Enter severity (1-5) and treatment time (minutes) for 
patient " + (i + 1) + ": "); 
            int severity = sc.nextInt(); 
            int treatmentTime = sc.nextInt(); 
            patients.add(new Patient(i + 1, severity, treatmentTime)); 
        } 
 
         
        PriorityQueue<Patient> pq = new PriorityQueue<>( 
            (a, b) -> (b.severity == a.severity) ? a.treatmentTime - b.treatmentTime : 
b.severity - a.severity 
        ); 
        pq.addAll(patients); 
 
        int[] doctorAvailableTime = new int[numDoctors]; 
        double totalWaitingTime = 0; 
 
        System.out.println("\n--- Scheduling Result ---"); 
        System.out.printf("%-10s %-10s %-10s %-10s %-10s\n", "Patient", 
"Severity", "Doctor", "Wait(min)", "Start(min)"); 
 
        while (!pq.isEmpty()) { 
            Patient p = pq.poll(); 
 
            // Find doctor who becomes free first 
            int chosenDoctor = 0; 
            for (int i = 1; i < numDoctors; i++) { 
                if (doctorAvailableTime[i] < doctorAvailableTime[chosenDoctor]) { 
                    chosenDoctor = i; 
                } 
            } 
 
            int waitingTime = doctorAvailableTime[chosenDoctor]; 
            totalWaitingTime += waitingTime; 
 
            System.out.printf("%-10d %-10d %-10d %-10d %-10d\n",  
                              p.id, p.severity, chosenDoctor + 1, waitingTime, 
doctorAvailableTime[chosenDoctor]); 
 
            doctorAvailableTime[chosenDoctor] += p.treatmentTime; 
        } 
 
        System.out.printf("\nAverage Waiting Time: %.2f minutes\n", 
totalWaitingTime / n); 
        sc.close(); 
    } 
} 
