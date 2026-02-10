# Persiapan: Kapasitas tetap 10 sesuai instruksi 
kapasitas = 10
daftar_nim = [""] * kapasitas
daftar_nama = [""] * kapasitas
count = 0  # Variabel penghitung elemen 

while True:
    print(f"\n=== STATUS ARRAY: {count}/{kapasitas} terisi ===")
    print("1. Insert Awal  2. Insert Posisi  3. Insert Akhir")
    print("4. Delete Awal  5. Delete Posisi  6. Delete Akhir")
    print("7. Delete Cari  8. Tampilkan      9. Keluar")
    
    pilih = input("Pilih Menu: ")

    # --- PROSES INSERT (TAMBAH) ---
    if pilih in ["1", "2", "3"]:
        if count >= kapasitas:
            print("Gagal: Array sudah penuh!"); continue
        
        n = input("NIM: "); m = input("Nama: ")

        if pilih == "1": # Insert at beginning [cite: 4]
            for i in range(count, 0, -1):
                daftar_nim[i] = daftar_nim[i-1]
                daftar_nama[i] = daftar_nama[i-1]
            daftar_nim[0] = n; daftar_nama[0] = m
        elif pilih == "2": # Insert at given position [cite: 5]
            pos = int(input("Index posisi: "))
            for i in range(count, pos, -1):
                daftar_nim[i] = daftar_nim[i-1]
                daftar_nama[i] = daftar_nama[i-1]
            daftar_nim[pos] = n; daftar_nama[pos] = m
        elif pilih == "3": # Insert at end [cite: 6]
            daftar_nim[count] = n; daftar_nama[count] = m
        
        count = count + 1 # Aturan: setiap insert, count + 1 

    # --- PROSES DELETE (HAPUS) ---
    elif pilih in ["4", "5", "6", "7"]:
        if count <= 0:
            print("Gagal: Data kosong!"); continue
            
        h = -1
        if pilih == "4": h = 0 # Delete from beginning [cite: 7]
        elif pilih == "5": h = int(input("Index hapus: ")) # Delete given position [cite: 8]
        elif pilih == "6": h = count - 1 # Delete from end [cite: 9]
        elif pilih == "7": # Delete first occurrence [cite: 10]
            cari = input("Cari NIM: ")
            for i in range(count):
                if daftar_nim[i] == cari: h = i; break
        
        if h != -1 and h < count:
            for i in range(h, count - 1):
                daftar_nim[i] = daftar_nim[i+1]
                daftar_nama[i] = daftar_nama[i+1]
            count = count - 1 # Aturan: setiap delete, count - 1 

    elif pilih == "8": # Show data [cite: 11]
        for i in range(count):
            print(f"Index {i} -> {daftar_nim[i]} | {daftar_nama[i]}")

    elif pilih == "9": break # Exit [cite: 12]