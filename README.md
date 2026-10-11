# Homework 6 — My First Compose App

## Task 3: Colour and Spacing
Colour used: `Color.LightGray`

Padding kept: 48.dp

What changed / what stayed the same: Ketika padding diubah dari 8 dp menjadi 48 dp, jarak antara tepi layar dan isi tampilan (tulisan dan gambar) menjadi jauh lebih lebar, sehingga isinya terlihat lebih masuk ke dalam dan sedikit turun. Hal yang tidak berubah adalah warna abu-abu dari Surface, isi tulisan, ukuran gambar, dan urutan elemen di dalam Column. Jika dibandingkan dengan margin berwarna kuning pada Module M06 Figure 13, padding merupakan ruang kosong di bagian dalam, di antara tepi dan isinya, sehingga warna Surface tetap terlihat sampai ke tepi layar.

## Task 4: Build Error
First error message:

```
'M' is not a valid file-based resource name character: File-based resource names must contain only lowercase a-z, 0-9, or underscore
```

Cause: Nama file gambar diganti menjadi `My-Picture.png`. Nama tersebut melanggar aturan penamaan resource di Android karena mengandung huruf kapital (M dan P) dan tanda hubung (-). Nama resource hanya boleh berisi huruf kecil a-z, angka 0-9, dan underscore.

Why other errors appear: Karena nama file tidak valid, gambar tersebut gagal diproses, sehingga ID `R.drawable.my_picture` tidak pernah dibuat. Akibatnya, kode yang memanggil `R.drawable.my_picture` ikut error, misalnya *unresolved reference*. Jadi error-error yang muncul belakangan hanyalah dampak dari satu masalah awal tersebut.

Fix: Nama file dikembalikan menjadi `my_picture.png`, lalu project di-build ulang. Build berhasil dan aplikasi dapat dijalankan kembali.

## Task 5: Explore the Project
(a) MainActivity: path `app/src/main/java/com/example/myfirstcomposeapp/MainActivity.kt` — file ini berisi class `MainActivity`, yaitu tempat aplikasi mulai berjalan. Di dalamnya, `setContent` dipakai untuk menampilkan layar Compose.

(b) Gradle file: path `app/build.gradle.kts` — file ini digunakan untuk mengatur modul app, seperti versi SDK, plugin, dan library yang dipakai.

(c) Launcher image line: `painter = painterResource(id = R.drawable.ic_launcher_foreground),` di dalam fungsi `MyFirstScreen`, yaitu baris 39 pada kode sebelum diubah di Task 2 — baris ini mengambil gambar ikon launcher dari folder drawable agar ditampilkan oleh `Image`.

## Task 6: Preview vs Run
Bukti: `screenshots/task6-preview.png` (Preview sudah berubah) dan `screenshots/task6-device.png` (emulator belum berubah).

Tulisan pertama di `MyFirstScreen` diubah dari "Hi! I am Aufa." menjadi "Halo! I am Aufa.", kemudian hanya Preview yang di-refresh tanpa menekan Run. Hasilnya, Preview langsung menampilkan tulisan baru, sedangkan aplikasi di emulator masih menampilkan tulisan lama. Hal ini terjadi karena Preview hanya menggambar composable di dalam Android Studio dan tidak memasang apa pun ke perangkat. Aplikasi di emulator adalah hasil build sebelumnya yang sudah terpasang. Agar perubahan muncul di perangkat, aplikasi perlu dijalankan lagi dengan Run, yaitu di-build ulang dan dipasang kembali ke emulator.

## Task 7: Views vs Compose
1. Pada Views (pendekatan imperatif), tampilan dibuat lebih dulu di file layout, lalu perubahan dilakukan lewat kode langkah demi langkah, misalnya dengan mencari komponen memakai `findViewById` dan mengubah tulisannya dengan `setText`. Jadi programmer yang mengatur setiap langkah perubahannya. Pada Compose (pendekatan deklaratif), programmer cukup menuliskan tampilan seperti apa yang diinginkan, dan Compose yang menggambarnya. Pada fungsi `MyFirstScreen` di project ini, `Surface` berisi `Column` yang memuat dua `Text` dan satu `Image`. Jika tulisan atau padding ingin diubah, cukup ubah nilainya di kode, lalu Compose akan menggambar ulang tampilannya.

2.

| Composable | Package | Library layer |
|---|---|---|
| Column | `androidx.compose.foundation.layout` | Foundation |
| Text | `androidx.compose.material3` | Material |
| Image | `androidx.compose.foundation` | Foundation |
