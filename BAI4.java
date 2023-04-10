/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package module7_kethua.dahinh;

/**
 *
 * @author Admin
 */
public class BAI4 {

    public abstract static class transaction {

        protected String maGiaoDich;
        protected String ngayGiaoDich;
        protected float donGia;
        protected float dienTich;

        abstract Double totalMoney();

        public transaction() {
        }

        public transaction(String maGiaoDich, String ngayGiaoDich, float donGia, float dienTich) {
            super();
            this.maGiaoDich = maGiaoDich;
            this.ngayGiaoDich = ngayGiaoDich;
            this.donGia = donGia;
            this.dienTich = dienTich;
        }

        public String getMaGiaoDich() {
            return maGiaoDich;
        }

        public void setMaGiaoDich(String maGiaoDich) {
            this.maGiaoDich = maGiaoDich;
        }

        public String getNgayGiaoDich() {
            return ngayGiaoDich;
        }

        public void setNgayGiaoDich(String ngayGiaoDich) {
            this.ngayGiaoDich = ngayGiaoDich;
        }

        public float getDonGia() {
            return donGia;
        }

        public void setDonGia(float donGia) {
            this.donGia = donGia;
        }

        public float getDienTich() {
            return dienTich;
        }

        public void setDienTich(float dienTich) {
            this.dienTich = dienTich;
        }

        @Override
        public String toString() {
            return "transaction{" + "maGiaoDich=" + maGiaoDich + ", ngayGiaoDich=" + ngayGiaoDich + ", donGia=" + donGia + ", dienTich=" + dienTich + '}';
        }
    }

    public enum LOAIDAT {
        A, B, C;
    }

    public static class transactionDat extends transaction {

        private String loaiDat;
        private LOAIDAT loaidat;

        public transactionDat() {
        }

        public String getLoaiDat() {
            return loaiDat;
        }

        public void setLoaiDat(String loaiDat) {
            this.loaiDat = loaiDat;
        }

        public LOAIDAT getLoaidat() {
            return loaidat;
        }

        public void setLoaidat(LOAIDAT loaidat) {
            this.loaidat = loaidat;
        }

        @Override
        public Double totalMoney() {
            var result = 0.0;
            if (getLoaidat() == LOAIDAT.A) {
                result = dienTich * donGia * 1.5;
            } else if (getLoaidat() == LOAIDAT.B || getLoaidat() == LOAIDAT.C) {

                result = dienTich * donGia;
            } else {

                throw  new RuntimeException("Invalid soil type.");
            }
            return result;
        }

        public transactionDat(LOAIDAT loaidat, String maGiaoDich, String ngayGiaoDich, float donGia, float dienTich) {
            super(maGiaoDich, ngayGiaoDich, donGia, dienTich);
            this.loaidat = loaidat;
        }
        
    }
    public enum LOAINHA{
        premium, normal;
    }
    public static class transactionNha extends transaction{
        private  LOAINHA loainha;
        private String diaChi;

        public LOAINHA getLoainha() {
            return loainha;
        }

        public void setLoainha(LOAINHA loainha) {
            this.loainha = loainha;
        }

        public String getDiaChi() {
            return diaChi;
        }

        public void setDiaChi(String diaChi) {
            this.diaChi = diaChi;
        }
        @Override
        public Double totalMoney(){
            var  result = 0.0;
            if(getLoainha() == LOAINHA.premium){
                result=dienTich*donGia;
                
            }
            else if (getLoainha()==LOAINHA.normal) {
                result = dienTich*donGia*0.9;
            }
            else {

                throw  new RuntimeException("Invalid house type.");
            }
            return result;
        }

        public transactionNha(LOAINHA loainha, String diaChi, String maGiaoDich, String ngayGiaoDich, float donGia, float dienTich) {
            super(maGiaoDich, ngayGiaoDich, donGia, dienTich);
            this.loainha = loainha;
            this.diaChi = diaChi;
        }

        public transactionNha() {
            super();
        }       
    }
    
    public static void main(String[] args) {
       transactionDat gdDat = new transactionDat();
       gdDat.setDienTich(50);
       gdDat.setDonGia(23);
       gdDat.setLoaidat(BAI4.LOAIDAT.A);
       
      Double totalgdDatA = gdDat.totalMoney();
      
       transactionDat gdDat02 = new transactionDat();
       gdDat02.setDienTich(50);
       gdDat02.setDonGia(23);
       gdDat02.setLoaidat(BAI4.LOAIDAT.B);
       Double toalgdDatB = gdDat02.totalMoney();
      
        transactionDat gdDat03 = new transactionDat();
       gdDat03.setDienTich(50);
       gdDat03.setDonGia(23);
       gdDat03.setLoaidat(BAI4.LOAIDAT.C);
      Double totalgdDatC = gdDat03.totalMoney();
      
      Double average = (totalgdDatC+totalgdDatA+totalgdDatC)/3;//trung bình thành tiền  của gd đất
      
      transactionNha gdNha =new transactionNha();
      gdNha.setDienTich(50);
      gdNha.setDonGia(33);
      gdNha.setLoainha(LOAINHA.normal);
      Double totalgdNhaNor = gdNha.totalMoney();
      
      transactionNha gdNha02 = new  transactionNha();
       gdNha02.setDienTich(50);
      gdNha02.setDonGia(33);
       gdNha02.setLoainha(LOAINHA.premium);
      Double totalgdNhaPre = gdNha02.totalMoney();
      
    }
}
                            