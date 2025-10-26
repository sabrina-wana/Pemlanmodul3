import java.util.Locale;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);


    // Enum satuan berbasis meter
    enum Unit {
        KM("km", 1000.0),
        HM("hm", 100.0),
        DAM("dam", 10.0),
        M("m", 1.0),
        DM("dm", 0.1),
        CM("cm", 0.01),
        MM("mm", 0.001);


        final String code; // kode input pengguna
        final double toMeter; // faktor konversi ke meter


        Unit(String code, double toMeter) {
            this.code = code;
            this.toMeter = toMeter;
        }


        static Unit from(String s) {
            String key = s.trim().toLowerCase();
            for (Unit u : values()) if (u.code.equals(key)) return u;
            throw new IllegalArgumentException("Satuan tidak dikenal: " + s);
        }
    }

    public static void main(String[] args) {
        System.out.println("==== Metric Unit Converter (km hm dam m dm cm mm) ====");
        boolean running = true;
        while (running) {
            printMenu();
            int menu = readInt("Pilih menu [1-3]: ");
            switch (menu) {
                case 1: convertOnce(); break;
                case 2: showTable(); break;
                case 3: running = false; break;
                default: System.out.println("Menu tidak valid.\n");
            }
        }
        System.out.println("Terima kasih! Keluar aplikasi.");
    }

    private static void printMenu() {
        System.out.println("\nMenu:");
        System.out.println("1) Konversi satuan");
        System.out.println("2) Tampilkan tabel faktor (ke meter)");
        System.out.println("3) Keluar");
    }


    private static void convertOnce() {
        double value = readDouble("Masukkan nilai: ");
        Unit from = readUnit("Dari satuan (km/hm/dam/m/dm/cm/mm): ");
        Unit to = readUnit("Ke satuan (km/hm/dam/m/dm/cm/mm): ");


        double result = convert(value, from, to);
        System.out.printf(Locale.US,
                "\n%.6f %s = %.6f %s\n",
                value, from.code, result, to.code);
    }

    // Konversi umum via meter
    static double convert(double value, Unit from, Unit to) {
        double inMeters = value * from.toMeter; // ke meter
        return inMeters / to.toMeter; // dari meter ke target
    }


    private static void showTable() {
        System.out.println("\nFaktor konversi ke meter (×):");
        for (Unit u : Unit.values()) {
            System.out.printf("%-3s : %s\n", u.code, formatDouble(u.toMeter));
        }
    }


    private static String formatDouble(double d) {
        if (Math.abs(d - Math.rint(d)) < 1e-12) return String.format("%.0f", d);
        return Double.toString(d);
    }


    private static int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Input harus bilangan bulat. Coba lagi.");
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Input harus angka (mis. 12 atau 3.5). Coba lagi.");
            }
        }
    }


    private static Unit readUnit(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Unit.from(sc.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + ". Gunakan salah satu: km, hm, dam, m, dm, cm, mm.");
            }
        }
    }
}