package datas;

import java.util.ArrayList;
import java.util.List;

public class data {
    public String[] suggestProduct(){
        String[] PRODUCTS =
                {
                        "MacBook Pro và MacBook Air của Apple",
                        "Dell XPS",
                        "HP Spectre x360",
                        "Lenovo ThinkPad X1 Carbon",
                        "Microsoft Surface Laptop",
                        "Asus ZenBook",
                        "Acer Swift",
                        "Razer Blade Stealth",
                        "MSI Prestige",
                        "LG Gram",
                        "Huawei MateBook",
                        "Samsung Notebook",
                        "Google Pixelbook",
                        "Toshiba Portege"
                };
        return PRODUCTS;
    }

    public List<String> getValueInfoConfiguration() {
        List<String> list = new ArrayList<>();
        list.add("AMD Ryzen 5 5600H");
        list.add("Windows 11");
        list.add("DDR4 8GB 3200MHZ, 2 slot up to 16 GB");
        list.add("Geforce GTX 1650 4GB");
        list.add("15.6 FHD 120HZ IPS ");
        list.add("256GB, SSD NVMe M.2 PCL Gen3");
        list.add("1000Mbps Ethernet");
        list.add("802.11ax 2x2 Wifi Bluetooth");
        list.add("2x USB 3.2 Gen1\n" +
                "1x power connector");
        list.add("4 Zones RGB");
        list.add("45Wh");
        list.add("359.6 x  251.9");
        list.add("2.25kg");
        return list;
    }

    public List<String> getKeyInfoConfiguration() {
        List<String> list = new ArrayList<>();
        list.add("CPU");
        list.add("Hệ điều hành");
        list.add("RAM");
        list.add("GPU");
        list.add("Màn hình");
        list.add("Ổ cứng SSD");
        list.add("LAN");
        list.add("Wireless LAN");
        list.add("Các cổng kết nối");
        list.add("Bàn phím");
        list.add("Pin");
        list.add("Kích thước");
        list.add("Trọng lượng");
        return list;
    }
}
