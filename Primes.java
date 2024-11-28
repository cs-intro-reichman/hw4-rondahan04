public class Primes {
    public static void main(String[] args) {
        final int num = Integer.parseInt(args[0]);
        int numSquare = (int) Math.sqrt(num);
        int p=2;
        int primecounter = 0;
        boolean [] rom = new boolean [num+1]; // the array of all numnbers
        for (int i = 2; i<rom.length;i++){ // sets 2 and above to true
            rom[i] = true;
        }
        while ( p <= numSquare){
            for(int i=p+1;i<rom.length;i++){ // checks p in rom
                if (i % p == 0){ // its a divisor, set it to false
                    rom[i] = false;
                }
            }
        p++;
        }
        System.out.println("Prime numbers up to " + num + ":");
        for (int i = 0 ; i<rom.length;i++){ // prints the primes
            if (rom[i] ==true){
                System.out.println(i);
                primecounter++;
            }
        }
        System.out.println("There are " + primecounter + " primes between " + 2 + " and " + (num) + " (" + (primecounter * 100 / num) + "% " + "are primes)");
    }
}