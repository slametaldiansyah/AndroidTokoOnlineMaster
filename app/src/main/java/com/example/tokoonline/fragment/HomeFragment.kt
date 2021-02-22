package com.example.tokoonline.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.tokoonline.R
import com.example.tokoonline.adapter.AdapterProduk
import com.example.tokoonline.adapter.AdapterSlider
import com.example.tokoonline.model.Produk

/**
 * A simple [Fragment] subclass.
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    lateinit var vpslider: ViewPager
    lateinit var rvProduk:RecyclerView
    lateinit var rvTerlaris:RecyclerView
    lateinit var rvElektronik:RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        //panggil id diview xml
        vpslider = view.findViewById(R.id.vp_slider)
        rvProduk = view.findViewById(R.id.rv_produk)
        rvTerlaris = view.findViewById(R.id.rv_terlaris)
        rvElektronik = view.findViewById(R.id.rv_elektronik)

        val arrSlider = ArrayList<Int>()
        arrSlider.add(R.drawable.slider1)
        arrSlider.add(R.drawable.slider2)
        arrSlider.add(R.drawable.slider3)

        val adapterSlider = AdapterSlider(arrSlider, activity)
        vpslider.adapter = adapterSlider

        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL

        val layoutManager2 = LinearLayoutManager(activity)
        layoutManager2.orientation = LinearLayoutManager.HORIZONTAL

        val layoutManager3 = LinearLayoutManager(activity)
        layoutManager3.orientation = LinearLayoutManager.HORIZONTAL


        rvProduk.adapter = AdapterProduk(arrProduk)
        rvProduk.layoutManager = layoutManager

        rvTerlaris.adapter = AdapterProduk(arrTerlaris)
        rvTerlaris.layoutManager = layoutManager2

        rvElektronik.adapter = AdapterProduk(arrElektronik)
        rvElektronik.layoutManager = layoutManager3

        return view
    }

    val arrProduk: ArrayList<Produk>get(){
        val arr = ArrayList<Produk>()
        val p1 = Produk()
        p1.nama = "Hp core I3"
        p1.harga = "Rp.5.000.000"
        p1.gambar = R.drawable.phone3

        val p2 = Produk()
        p2.nama = "Hp core I5"
        p2.harga = "Rp.25.000.000"
        p2.gambar = R.drawable.phone4

        val p3 = Produk()
        p3.nama = "Hp core I9"
        p3.harga = "Rp.50.000.000"
        p3.gambar = R.drawable.phone5

        arr.add(p1)
        arr.add(p2)
        arr.add(p3)

        return arr
    }

    val arrElektronik: ArrayList<Produk>get(){
        val arr = ArrayList<Produk>()
        val p1 = Produk()
        p1.nama = "Hp core I3"
        p1.harga = "Rp.5.000.000"
        p1.gambar = R.drawable.phone3

        val p2 = Produk()
        p2.nama = "Hp core I5"
        p2.harga = "Rp.25.000.000"
        p2.gambar = R.drawable.phone4

        val p3 = Produk()
        p3.nama = "Hp core I9"
        p3.harga = "Rp.50.000.000"
        p3.gambar = R.drawable.phone5

        arr.add(p1)
        arr.add(p2)
        arr.add(p3)

        return arr
    }

    val arrTerlaris: ArrayList<Produk>get(){
        val arr = ArrayList<Produk>()
        val p1 = Produk()
        p1.nama = "Hp core I3"
        p1.harga = "Rp.5.000.000"
        p1.gambar = R.drawable.phone3

        val p2 = Produk()
        p2.nama = "Hp core I5"
        p2.harga = "Rp.25.000.000"
        p2.gambar = R.drawable.phone4

        val p3 = Produk()
        p3.nama = "Hp core I9"
        p3.harga = "Rp.50.000.000"
        p3.gambar = R.drawable.phone5

        arr.add(p1)
        arr.add(p2)
        arr.add(p3)

        return arr
    }
}