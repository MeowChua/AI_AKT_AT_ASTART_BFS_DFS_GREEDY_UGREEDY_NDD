package DONG_NUOC;

public class BinhNuoc {
    private int mucNuoc;
    private int mucNuocToiDa;

    public BinhNuoc(int mucNuocToiDa) {
        this.mucNuoc = 0;
        this.mucNuocToiDa = mucNuocToiDa;
    }
    public BinhNuoc(BinhNuoc n){
        this.mucNuocToiDa = n.mucNuocToiDa;
        this.mucNuoc= n.mucNuoc;
    }
    public BinhNuoc(int mucNuoc, int mucNuocToiDa) {
        this.mucNuoc = mucNuoc;
        this.mucNuocToiDa = mucNuocToiDa;
    }

    public int getMucNuoc() {
        return mucNuoc;
    }

    public int getMucNuocToiDa() {
        return mucNuocToiDa;
    }

    public void setMucNuoc(int mucNuoc) {
        this.mucNuoc = mucNuoc;
    }

    public void setMucNuocToiDa(int mucNuocToiDa) {
        this.mucNuocToiDa = mucNuocToiDa;
    }

    public void full() {
        this.mucNuoc = this.mucNuocToiDa;
    }

    public void aToB(BinhNuoc binhA) {
        if(binhA.getMucNuoc() == 0)
            return;
        if(this.mucNuoc == this.mucNuocToiDa)
            return;
        int can = this.mucNuocToiDa - this.mucNuoc;
        if(binhA.getMucNuoc() >= can) {
            this.mucNuoc = this.mucNuocToiDa;
            binhA.setMucNuoc(binhA.getMucNuoc() - can);
        }
        else {
            this.mucNuoc += binhA.getMucNuoc();
            binhA.setMucNuoc(0);
        }
    }

    public void empty() {
        this.mucNuoc = 0;
    }

    @Override
    public String toString() {
        return "BinhNuoc{" +
                "mucNuoc=" + mucNuoc +
                ", mucNuocToiDa=" + mucNuocToiDa +
                '}';
    }
}
