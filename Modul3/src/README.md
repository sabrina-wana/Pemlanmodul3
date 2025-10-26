# Metric Unit Converter (Java CLI)


Konverter satuan **panjang** antarsatuan metrik: `km`, `hm`, `dam`, `m`, `dm`, `cm`, `mm`.


## 🎯 Tujuan Proyek
- Latihan Git (init → commit → push) dan pembuatan proyek Java sederhana.
- Menunjukkan desain enum + validasi input pada aplikasi CLI.


## ✨ Fitur
- Konversi dua-arah antar semua pasangan satuan.
- Tabel faktor ke meter (untuk belajar konsep prefiks metrik).
- Validasi input (kode satuan & angka) + pesan error yang ramah.


## 🛠️ Prasyarat
- **Java 8+**


## ▶️ Cara Menjalankan
bash
# 1) Kompilasi
javac Main.java
# 2) Jalankan
java Main

📌 Cara Pakai (Alur CLI)

Pilih 1 untuk konversi atau 2 untuk melihat tabel faktor.
Masukkan nilai, satuan asal (km/hm/dam/m/dm/cm/mm), dan satuan tujuan.
Hasil akan ditampilkan dengan enam angka di belakang koma (format US locale).

🧪 Contoh Output

==== Metric Unit Converter (km hm dam m dm cm mm) ====


Menu:
1) Konversi satuan
2) Tampilkan tabel faktor (ke meter)
3) Keluar
Pilih menu [1-3]: 1
Masukkan nilai: 1.75
Dari satuan (km/hm/dam/m/dm/cm/mm): km
Ke satuan (km/hm/dam/m/dm/cm/mm): m


1.750000 km = 1750.000000 m

Contoh lain:

Pilih menu [1-3]: 1
Masukkan nilai: 1200
Dari satuan (km/hm/dam/m/dm/cm/mm): cm
Ke satuan (km/hm/dam/m/dm/cm/mm): m


1200.000000 cm = 12.000000 m

Tabel faktor (menu 2):

Faktor konversi ke meter (×):
km : 1000
hm : 100
dam : 10
m : 1
dm : 0.1
cm : 0.01
mm : 0.001
