package com.example.tugas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
    public SliderAdapter(Context context){
        this.context = context;
    }


    //arrays
    public int[] slide_images = {
            R.drawable.bromo,
            R.drawable.giliketapang,
            R.drawable.bjbr
    };
    public  String[] slide_headings = {
            "BROMO",
            "GILI KETAPANG",
            "BJBR"
    };
    public  String[] slide_descs = {
                    "Gunung Bromo (dari bahasa Sanskerta: Brahma, salah seorang Dewa Utama dalam agama Hindu) atau dalam "+
                    "bahasa Tengger dieja Brama, adalah sebuah gunung berapi aktif di Jawa Timur, Indonesia."+
                    "Gunung ini memiliki ketinggian 2.329 meter di atas permukaan laut dan berada dalam empat wilayah "+
                    "kabupaten, yakni Kabupaten Probolinggo, Kabupaten Pasuruan, Kabupaten Lumajang, dan Kabupaten Malang."+
                    "Gunung Bromo termasuk dalam kawasan Taman Nasional Bromo Tengger Semeru."+
                    "Bentuk tubuh Gunung Bromo bertautan antara lembah dan ngarai dengan kaldera atau lautan pasir seluas sekitar 10 kilometer persegi. Ia mempunyai sebuah "+
                    "kawah dengan garis tengah ± 800 meter (utara-selatan) dan ± 600 meter (timur-barat). Sedangkan daerah bahayanya berupa lingkaran dengan jari-jari 4 km dari pusat kawah Bromo."+
                    "SEJARAH LETUSAN"+
                    "Selama abad 20 dan abad 21, Gunung Bromo telah meletus sebanyak beberapa kali, dengan interval waktu yang teratur, yaitu 30 tahun. Letusan terbesar terjadi 1974, sedangkan letusan terakhir terjadi pada 2015-sekarang."+
                    "BROMO SEBAGAI GUNUNG SUCI"+
                    "Bagi penduduk sekitar Gunung Bromo, suku Tengger, Gunung Bromo/Gunung Brahma dipercaya sebagai gunung suci. Setiap setahun sekali masyarakat Tengger mengadakan upacara Yadnya Kasada atau Kasodo. Upacara ini bertempat di sebuah pura yang berada di bawah kaki Gunung Bromo dan "+
                    "dilanjutkan ke puncak Bromo. Upacara diadakan pada tengah malam hingga dini hari setiap bulan purnama sekitar tanggal 14 atau 15 di bulan Kasodo (kesepuluh) menurut penanggalan Jawa.",


                    "Gili Ketapang adalah sebuah desa dan pulau kecil di Selat Madura, tepatnya 8 km di lepas pantai"+
                    "utara Probolinggo.Secara administratif, pulau ini termasuk wilayah Kecamatan Sumberasih, Kabupaten Probolinggo, Jawa Timur."+
                    "Luas wilayahnya sekitar 68 ha, dan jumlah penduduknya 7.600 jiwa (2004), yang sebagian besar adalah" +
                    "Suku Madura dan bermata pencaharian sebagai nelayan. Penduduk pulau ini dikenal relatif makmur."+
                    "Gili Ketapang merupakan salah satu tujuan wisata alam di Kabupaten Probolinggo."+
                    "Pulau terebut dihubungkan dengan Pulau Jawa dengan perahu motor melalui Pelabuhan Tanjung Tembaga, Kota Probolinggo, dengan waktu tempuh sekitar 30 menit." +
                    "gempa yang dahsyat akibat letusan Gunung Semeru. Nama Gili Ketapang berasal dari bahasa Madura, gili yang artinya mengalir, dan Ketapang merupakan nama asal desa tersebut." +
                    "Menurut legenda setempat, pulau ini dulunya menyatu dengan daratan Desa Ketapang (Pulau Jawa), yang kemudian secara gaib bergerak lamban ke tengah laut, karena ",


                    "Wisata BJBR Probolinggo atau yang juga dikenal dengan sebutan Mangrove Beejay Bakau Resort adalah sebuah wisata hutan di Kota Probolinggo."+
                    "bakau seluas 5 hektar yang terletak di pesisir pantai. BJBR termasuk salah satu destinasi wisata favorit yang terletak " +
                    " Hutan bakau muara kali Banger ini pada mulanya adalah sebuah tempat kumuh yang dipenuhi dengan" +
                    "sampah. Berkat 3 pemuda brilian, tempat ini disulap menjadi sebuah tempat wisata yang eksotis."+
                    "Apresiasi besar terhadap ketiga sosok tersebut karena telah mengubah sesuatu negatif menjadi sesuatu yang bernilai."+
                    "BJBR Probolinggo dibangun pada tahun 2013, dan langsung disambut hangat oleh para wisatawan. Berita tentang keberadaan tempat wisata itu pun tersebar luas dengan sangat cepat. Tidak heran apabila Wisata BJBR Probolinggo selalu dipenuhi wisatawan dari luar daerah."+
                    "Terdapat 3 jenis tiket yang dikenakan kepada wisatawan yang berkunjung ke BJBR Probolinggo." +
                    "*Tiket masuk gerbang pelabuhan: Rp.3000," +
                    "*Tiket masuk BJBR: Rp.10.000," +
                    "*Tiket parkir kendaraan Rp.2.000" +
                    "Jadi biaya yang harus dikeluarkan kurang lebih Rp.15.000. Dan tidak menutup kemungkinan adanya perubahan harga nantinya."+""+"",
    };
    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(RelativeLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = (ImageView)view.findViewById(R.id.imageView);
        TextView slideHeading = (TextView)view.findViewById(R.id.slide_heading);
        TextView slideDescription = (TextView)view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_descs[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
