package Programlamadilleri;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

class programlamadilleri extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    JLabel label, label1, label2, label3, label4;
    JRadioButton radioButton[] = new JRadioButton[5];
    JButton btn_yeni_soru, btn_bos_birak;
    ButtonGroup bg;
    int count = 0, current = 0, x = 1, y = 1, now = 0;
    int m[] = new int[121];

    programlamadilleri(String s) {
        super(s);
        label = new JLabel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();

        add(label);
        add(label1);
        add(label2);
        add(label3);
        add(label4);
        bg = new ButtonGroup();
        for (int i = 0; i < 5; i++) {
            radioButton[i] = new JRadioButton();
            add(radioButton[i]);
            bg.add(radioButton[i]);
        }
        btn_yeni_soru = new JButton("Sonraki Soru");
        btn_bos_birak = new JButton("Boş bırak");
        btn_yeni_soru.addActionListener(this);
        btn_bos_birak.addActionListener(this);
        add(btn_yeni_soru);
        add(btn_bos_birak);
        set();
        label.setBounds(30, 40, 600, 20);
        label1.setBounds(30, 60, 600, 20);
        label2.setBounds(30, 80, 600, 20);
        label3.setBounds(30, 100, 600, 20);
        label4.setBounds(30, 120, 600, 20);

        radioButton[0].setBounds(50, 200, 450, 20);
        radioButton[1].setBounds(50, 230, 200, 20);
        radioButton[2].setBounds(50, 250, 200, 20);
        radioButton[3].setBounds(50, 280, 200, 20);
        btn_yeni_soru.setBounds(100, 310, 100, 30);
        btn_bos_birak.setBounds(270, 310, 100, 30);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
        setSize(800, 400);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_yeni_soru) {
            if (check()) {
                count = count + 1;
            }
            current++;
            set();
            if (current == 123) {
                btn_yeni_soru.setEnabled(false);
                btn_bos_birak.setText("Sonuç");
            }
        }
        if (e.getActionCommand().equals("Boş bırak")) {
            JButton bk = new JButton("Boş bırak" + x);
            bk.setBounds(480, 20 + 30 * x, 100, 30);
            add(bk);
            bk.addActionListener(this);
            m[x] = current;
            x++;
            current++;
            set();
            if (current == 123) {
                btn_bos_birak.setText("Sonuç");
            }
            setVisible(false);
            setVisible(true);
        }
        for (int i = 0, y = 1; i < x; i++, y++) {
            if (e.getActionCommand().equals("Boş bırak" + y)) {
                if (check()) {
                    count = count + 1;
                }
                now = current;
                current = m[y];
                set();
                ((JButton) e.getSource()).setEnabled(false);
                current = now;
            }
        }

        if (e.getActionCommand().equals("Sonuç")) {
            if (check()) {
                count = count + 1;
            }
            current++;
            JOptionPane.showMessageDialog(this, " Toplam soru sayısı= 122"
                    + "    " + "Doğru cevaplanılan soru sayısı= " + count);
            System.exit(0);
        }
    }

    void set() {
        radioButton[4].setSelected(true);
        if (current == 0) {
            label.setText("1) ((5-(25/9)) / (2/3))-(1/3) işleminin sonucu kaçtır?");
            radioButton[0].setText("1");
            radioButton[1].setText("2");
            radioButton[2].setText("3");
            radioButton[3].setText("4");

        }
        if (current == 1) {
            label.setText("2) ((60^2)*3) / 15^3 işleminin sonucu kaçtır ?");
            radioButton[0].setText("2,4");
            radioButton[1].setText("2,6");
            radioButton[2].setText("2.8");
            radioButton[3].setText("3,2");
        }
        if (current == 2) {
            label.setText("3) (√48 + √75) / (√108 - √27) işleminin sonucu kaçtır ?");
            radioButton[0].setText("1");
            radioButton[1].setText("2");
            radioButton[2].setText("3");
            radioButton[3].setText("4");
        }
        if (current == 3) {
            label.setText("4) (6! + 7!) / ((4!)^2 ) işleminin sonucu kaçtır ?");
            radioButton[0].setText("10");
            radioButton[1].setText("12");
            radioButton[2].setText("15");
            radioButton[3].setText("18");
        }
        if (current == 4) {
            label.setText("5) x/y,x-y,x sayıları küçükten büyüğe doğru sıralanmış");
            label1.setText("ardışık üç çift tam sayıdır. Buna göre x+y toplamı kaçtır ?");
            radioButton[0].setText("8");
            radioButton[1].setText("10");
            radioButton[2].setText("12");
            radioButton[3].setText("14");
        }
        if (current == 5) {
            label.setText("6) a ve b birbirinden farklı pozitif tam sayılar olmak üzere EKOK(a,b) bir asal sayıya eşittir. Buna göre,");
            label1.setText("1. a ve b aralarında asal sayılardır.");
            label2.setText("2. a + b toplamı bir tek sayıdır.");
            label3.setText("3. a.b çarpımı bir tek sayıdır.");
            label4.setText("İfadelerinden hangileri her zaman doğrudur?");
            radioButton[0].setText("Yalnız 1");
            radioButton[1].setText("Yalnız 2");
            radioButton[2].setText("Yalnız 3");
            radioButton[3].setText("1 ve 2");
        }
        if (current == 6) {
            label.setText("7) (xz-yz + xy – y^2) / (x^2 – xy + xz – yz) ifadesinin sadeleştirilmiş");
            label1.setText("biçimi aşağıdakilerden hangisidir?");
            label2.setText("");
            label3.setText("");
            label4.setText("");

            radioButton[0].setText("(z-y) / (x-z )");
            radioButton[1].setText("(y+z) / (x+z)");
            radioButton[2].setText("(x+z) / (y+z)");
            radioButton[3].setText(" x / (x+y) ");
        }
        if (current == 7) {
            label.setText("8) a,b ve c pozitif gerçel sayıları için,");
            label1.setText("(a+c) / (b+2) = c/b");
            label2.setText(" a/b =c");
            label3.setText("eşitlikleri veriliyor. Buna göre, b kaçtır?");
            label4.setText("");

            radioButton[0].setText("√2");
            radioButton[1].setText("√3");
            radioButton[2].setText("√6 I");
            radioButton[3].setText("2");
        }
        if (current == 8) {
            label.setText("9) (1/√a)- (2/√9a) =1");
            label1.setText("olduğuna göre, a kaçtır?");
            label2.setText("");
            label3.setText("");
            label4.setText("");

            radioButton[0].setText("1/3");
            radioButton[1].setText("2/3");
            radioButton[2].setText("1/4");
            radioButton[3].setText("1/9");
        }
        if (current == 9) {
            label.setText("10) Sıfırdan farklı x,y ve gerçel sayılarının mutlak değerleri birbirinden farklı olmak üzere,");
            label1.setText("|x+y| = |x|-|y| ,  |y+z| = |y|+|z| Eşitlikleri sağlanmaktadır. x>0 olduğuna göre,");
            label2.setText("1. ( x/ (x+y) ) <1");
            label3.setText("2. ( y/ (y+z) ) <1");
            label4.setText("3. ( z/ (x+z) )<1  " + "   İfadelerinden hangileri her zaman doğrudur?");

            radioButton[0].setText("Yalnız 1");
            radioButton[1].setText("Yalnız 2");
            radioButton[2].setText("Yalnız 3");
            radioButton[3].setText("1 ve 3");

        }
        if (current == 10) {
            label.setText("11) Üç basamaklı ADB,ADC,DAA,DAD doğal sayıları");
            label1.setText("ADB<DAA");
            label2.setText("DAD<ADC");
            label3.setText("eşitsizliklerini sağlamaktadır.");
            label4.setText("Buna göre,aşağıdaki sıralamardan hangisi doğrudur?");

            radioButton[0].setText("A=D<B<C");
            radioButton[1].setText("C<A=B<D");
            radioButton[2].setText("D<A=B<C");
            radioButton[3].setText("B<A=D<C");

        }
        if (current == 11) {
            label.setText("12) Sıfırdan farklı x ve y gerçel sayıları için y<x ve x^2<y^2 olduğuna göre,");
            label1.setText("1. x.y>0");
            label2.setText("2. x+y<0");
            label3.setText("3.  1/x-1/y>0");
            label4.setText("ifadelerinden hangileri her zaman doğrudur?");

            radioButton[0].setText("Yalnız 2");
            radioButton[1].setText("1 ve 2");
            radioButton[2].setText("1 ve 3");
            radioButton[3].setText("2 ve 3");

        }
        if (current == 12) {
            label.setText("13) A kümesi,{1,2,3,4,5,6,7}kümesinin bir alt kümesi olmak üzere,");
            label1.setText("A ∩ {5,6,7}");
            label2.setText("kümesinin elemanları tek sayılardır.");
            label3.setText("Buna göre,bu koşulu sağlayan üç elemanlı kaç tane A kümesi vardır?");
            label4.setText("");

            radioButton[0].setText("12");
            radioButton[1].setText("14");
            radioButton[2].setText("16");
            radioButton[3].setText("18");

        }
        if (current == 13) {
            label.setText("14) A,B ve C kümeleri  A={(x,x):x ∈ R}, B={x,3-x):x ∈ R},");
            label1.setText("C={(x,x+4):x ∈ R} şeklinde tanımlanıyor.");
            label2.setText("(p,q) ∈ A ∩ B ve (r,s) ∈ B ∩ C olduğuna göre,");
            label3.setText("p-r)/(q+s) ifadesinin değeri kaçtır? (d)");
            label4.setText("");

            radioButton[0].setText("1/4");
            radioButton[1].setText("3/4");
            radioButton[2].setText("4/5");
            radioButton[3].setText("2/5");

        }
        if (current == 14) {
            label.setText("15) Gerçel sayılar kümesi üzerinde f ve g fonksiyonları");
            label1.setText("f(x)=(x.(x-2))/2");
            label2.setText("g(x)=(x.(x-1).(x-2))/3");
            label3.setText("biçiminde tanımlanıyor.");
            label4.setText("f(2x)=g(x+1), eşitliğini sağlayan x değerlerinin toplamı kaçtır?");

            radioButton[0].setText("1");
            radioButton[1].setText("3");
            radioButton[2].setText("4");
            radioButton[3].setText("6");

        }
        if (current == 15) {
            label.setText("16) Gerçel sayılar kümesi üzerinde bir f fonksiyonu,");
            label1.setText("her x gerçel sayısı için n tam sayı olmak üzere,");
            label2.setText("f(x)=x-n, x ∈ [n,n+1) biçiminde tanımlanıyor.");
            label3.setText("Buna göre,");
            label4.setText("f(1)+f(7/3)+f(13/6) toplamı kaçtır?");

            radioButton[0].setText("1/2");
            radioButton[1].setText("2/3");
            radioButton[2].setText("7/6");
            radioButton[3].setText("1");

        }
        if (current == 16) {
            label.setText("17) Gerçel sayılar kümesi üzerinde bir f fonksiyonu");
            label1.setText("f(x) = |x|/1+|x| biçiminde tanımlanıyor.");
            label2.setText("Buna göre,");
            label3.setText("[-2,1) aralığının f fonksiyonualtındaki görüntü kümesi aşağıdakilerden hangisidir?");
            label4.setText("");
            radioButton[0].setText("[0,1]");
            radioButton[1].setText("(1/3,2/3]");
            radioButton[2].setText("[1/3,2/3)");
            radioButton[3].setText("[0,2/3]");

        }
        if (current == 17) {
            label.setText("18) a ve b doğal sayılar olmak üzere,");
            label1.setText("4.a ≡ 2(mod 11)");
            label2.setText("4.b ≡ 5(mod 7)");
            label3.setText("denklikleri veriliyor.");
            label4.setText("Buna göre a+b toplamının alabileceği en küçük değer kaçtır?");

            radioButton[0].setText("7");
            radioButton[1].setText("9");
            radioButton[2].setText("11");
            radioButton[3].setText("13");

        }
        if (current == 18) {
            label.setText("19) Pelin'in hesaap makinesi,\"3\" tuşuna her basıldığında bunu 1/6 olasılıkla 3, 1/3 olasılıkla 4,");
            label1.setText("1/2 olasılıkla 6  olarak algılanmaktadır.");
            label2.setText("Pelin sadece \"3\" numaraları tuşu bozuk olan bu hesap makinesiyle");
            label3.setText("23-(12/3) işlemini yapacaktır.");
            label4.setText("Buna göre,Pelin'in bu işlemin sonucu 22 bulma olasılığı kaçtır?");
            radioButton[0].setText("1/3");
            radioButton[1].setText("1/4");
            radioButton[2].setText("1/9");
            radioButton[3].setText("5/12");

        }
        if (current == 19) {
            label.setText("20) İki gerçel kökü olan x^2-ax+1=0 denklemininkökleri toplamı");
            label1.setText("x^2+6x+a=0");
            label2.setText("denkleminin bir köküdür.Buna göre, a kaçtır?");
            label3.setText("");
            label4.setText("");
            radioButton[0].setText("-4");
            radioButton[1].setText("-5");
            radioButton[2].setText("-6");
            radioButton[3].setText("-7");

        }
        if (current == 20) {
            label.setText("21) (1-i^2).(1-i^6).(1-i^10) / (1-i).(1-i^3).(1-i^5)");
            label1.setText("işleminin sonucu kaçtır?(D)");
            label2.setText("");
            label3.setText("");
            label4.setText("");
            
            radioButton[0].setText("1");
            radioButton[1].setText("2");
            radioButton[2].setText("2+i");
            radioButton[3].setText("2+2i");

        }
        if (current == 21) {
            label.setText("22) 4z-3z= 1-18i/2-i eşitliğini sağlayan z karmaşık sayısı");
            label1.setText("aşağıdakilerden hangisidir?");
            label2.setText("");
            label3.setText("");
            label4.setText("");
            radioButton[0].setText("-2+i");
            radioButton[1].setText("-3+i");
            radioButton[2].setText("4+2i");
            radioButton[3].setText("3-2i");

        }
        if (current == 22) {
            label.setText("23) (x-1)^2 <|x-1|+6");
            label1.setText("eşitsizliğini sağlayan x tam sayılarının toplamı kaçtır?");
            label2.setText("");
            label3.setText("");
            label4.setText("");
            
            radioButton[0].setText("2");
            radioButton[1].setText("3");
            radioButton[2].setText("4");
            radioButton[3].setText("5");

        }
        if (current == 23) {
            label.setText("24) (6x+1) / (x+1)^2 >1 eşitsizliğini sağlayan tüm gerçel sayıların kümesi aşağıdakilerden hangisidir?");
            label1.setText("");
            label2.setText("");
            label3.setText("");
            label4.setText("");
           
            radioButton[0].setText("(-1,4)");
            radioButton[1].setText("(-1,6)");
            radioButton[2].setText("(0,4)");
            radioButton[3].setText("(0,∞)");

        }
        if (current == 24) {
            label.setText("25) Üçüncü dereceden gerçel katsayılı polinomununkökleri -3,-1 ve 2’dir.");
            label1.setText("P(0)=12 olduğuna göre, x^2 li terimin katsayısı kaçtır?");
            label2.setText("");
            label3.setText("");
            label4.setText("");
            
            radioButton[0].setText("-4");
            radioButton[1].setText("-3");
            radioButton[2].setText("-2");
            radioButton[3].setText("1");

        }
        if (current == 25) {
            label.setText("26) a ve b tam sayılar olmak üzere");
            label1.setText("P(x)=x^3-ax^2-(b+2)x+4b, Q(x)=x^2-2ax+b polinomları için");
            label2.setText("P(-4)= 0");
            label3.setText("Q(-4)≠ 0   olduğu biliniyor.");
            label4.setText("Q(x) polinomunun kökleri aynı zamanda P(x) polinomunun da kökleri olduğuna göre, farkı kaçtır?");
           
            radioButton[0].setText("8");
            radioButton[1].setText("9");
            radioButton[2].setText("11");
            radioButton[3].setText("13");

        }
        if (current == 26) {
            label.setText("27) Katsayıları {0,1,2,......,9} kümesinin elemanlarından");
            label1.setText("ve bir kökü  -2/3 olan ikinci dereceden polinomlarınsayısı kaçtır?");
            label2.setText("");
            label3.setText("");
            label4.setText("");
            
            radioButton[0].setText("5");
            radioButton[1].setText("7");
            radioButton[2].setText("8");
            radioButton[3].setText("10");

        }
        if (current == 27) {
            label.setText("28) p, q ve r önermeleri için(p=>q)=>r önermesinin yanlış olduğu biliniyor. Buna göre,");
            label1.setText("I. p=>q");
            label2.setText("II.q=>r");
            label3.setText("III.r=>p");
            label4.setText("önermelerinden hangileri her zaman doğrudur?");
            
            radioButton[0].setText("Yalnız 1");
            radioButton[1].setText("Yalnız 2 ");
            radioButton[2].setText("Yalnız 3");
            radioButton[3].setText("1 ve 3");

        }
        if (current == 28) {
            label.setText("29) Bir öğrenci, doğru olduğunu düşündüğü aşağıdaki iddiayı ispatlarken bir hata yapmıştır. İddia : π sayısı e sayısına eşittir.\n");
            label1.setText("Öğrencinin ispatı :x>0 için f(x) ve g(x) fonksiyonları f(x)=ln(πx) ve g(x)=ln(ex) olarak tanımlansın.");
            label2.setText("1. Her x>0 için f(x) ve g(x) fonksiyonlarının türevleri birbirine eşittir. 2. Dolayısıyla her x>0 için f(x) ve g(x) fonksiyonları birbirine eşittir. 3. ln(x) fonksiyonu bire bir ve f(x)=g(x)");
            label3.setText("olduğundan her  x>0 için πx=ex olduğu sonucuna varılır. 4. Eğer iki fonksiyon her x>0 için birbirine eşitse,bu fonksiyonların x=1’deki değerleri aynıdır.");
            label4.setText("Bu öğrenci, numaralandırılmış adımların hangisinde hata yapmıştır?");
            
            radioButton[0].setText("1");
            radioButton[1].setText("2");
            radioButton[2].setText("3");
            radioButton[3].setText("4");

        }
        if (current == 29) {
            label.setText("30) x^ln4 - 6.2^lnx +8 = 0");
            label1.setText("denklemini sağlayan x değerlerinin çarpımı kaçtır?");
            label2.setText("");
            label3.setText("");
            label4.setText("");
            
            radioButton[0].setText("e^6");
            radioButton[1].setText("e^4");
            radioButton[2].setText("e^3");
            radioButton[3].setText("e^2/2");

        }
        if (current == 30) {
            label.setText("31) log3√27+log27√3 / log3√27-log27√3");
            label1.setText("işleminin sonucu kaçtır?");
            label2.setText("");
            label3.setText("");
            label4.setText("");
            
            radioButton[0].setText("3/2");
            radioButton[1].setText("4/3");
            radioButton[2].setText("5/4");
            radioButton[3].setText("6/5");

        }
        if (current == 31) {
            label.setText("32)");
            label1.setText("lnx+lny=9");
            label2.setText("lnx-lny=3");
            label3.setText("olduğuna göre,logyX değeri kaçtır?");
            label4.setText("");
            
            radioButton[0].setText("1");
            radioButton[1].setText("2");
            radioButton[2].setText("3");
            radioButton[3].setText("4");

        }
        if (current == 32) {
            label.setText("33) (an)bir aritmetik dizi olmak üzere,");
            label1.setText("a10+a7=6");
            label2.setText("a9-a6=1");
            label3.setText("eşitlikleri veriliyor.");
            label4.setText("Buna göre,a1 kaçtır?");
            
            radioButton[0].setText("7/3");
            radioButton[1].setText("5/2");
            radioButton[2].setText("4/3");
            radioButton[3].setText("1/2");

        }
        if (current == 33) {
            label.setText("34) (n pozitif bir tam sayı olmak üzere,");
            label1.setText("n, ∑ (-1)^k+1(k)=10, k=1 eşitliği veriliyor.");
            label2.setText("Buna göre, n kaçtır?");
            label3.setText("");
            label4.setText("");
            
            radioButton[0].setText("18");
            radioButton[1].setText("19");
            radioButton[2].setText("20");
            radioButton[3].setText("21");

        }
        if (current == 34) {
            label.setText("(35) lim    x^2.sin(π-x)+π^2.sin(x-π) / (x-π)^2");
            label1.setText("    x-->π");
            label2.setText("limitinin değeri kaçtır?");
            label3.setText("");
            label4.setText("");
            radioButton[0].setText("-2π");
            radioButton[1].setText("-π");
            radioButton[2].setText("π");
            radioButton[3].setText("2π");

        }
        if (current == 35) {
            label.setText("36) Gerçel sayılar kümesinde tanımlı f fonksiyonu her x için 1≤f(x)≤2 eşitsizliklerini sağlıyor. Buna göre,");
            label1.setText("1.lim    1/f(x) x-->1 vardır.");
            label2.setText("2.lim    f(x)/x x-->1 vardır.");
            label3.setText("3.lim    (|f(x)|-f(x)) x-->1 vardır.");
            label4.setText("ifadelerinden hangileri her zaman doğrudur?");
            
            radioButton[0].setText("Yalnız 1");
            radioButton[1].setText("Yalnız 2");
            radioButton[2].setText("Yalnız 3");
            radioButton[3].setText("Yalnız 4");

        }
        if (current == 36) {
            label.setText("37) f(x)=√(x+√x) fonksiyonu için f'(1) değeri kaçtır?");
            label1.setText("");
            label2.setText("");
            label3.setText("");
            label4.setText("");
            radioButton[0].setText("3/4√2");
            radioButton[1].setText("1/2√2");
            radioButton[2].setText("1/√2");
            radioButton[3].setText("3/√2");

        }
        if (current == 37) {
            label.setText("38) Gerçel sayılar kümesi üzerinde tanımlı");
            label1.setText("f(x)=sin(x/2)");
            label2.setText("fonksiyonu için (f o f)'(2π) değeri kaçtır?");
            label3.setText("");
            label4.setText("");
            
            radioButton[0].setText("-1/2");
            radioButton[1].setText("-1/4");
            radioButton[2].setText("1/4");
            radioButton[3].setText("1/2");

        }
        if (current == 38) {
            label.setText("39) Bir ayrıtı x birim uzunluğunda olan küp şeklindeki bir kristalin üretim maliyeti hacim üzerinden birimküp");
            label1.setText("başına 5 TL, satış fiyatı ise yüzey alanı üzerinden birimkare başına 20 TL olarak hesaplanmaktadır.");
            label2.setText("Buna göre, x kaç birim olursa bu kristalin satışından elde edilen kâr en fazla olur?");
            label3.setText("");
            label4.setText("");
            
            radioButton[0].setText("16");
            radioButton[1].setText("18");
            radioButton[2].setText("20");
            radioButton[3].setText("22");

        }
        if (current == 39) {
            label.setText("40) a ve b gerçel sayılar olmak üzere,");
            label1.setText("f(x)=a.lnx+b.x^2+3");
            label2.setText("fonksiyonunun grafiğine(1,f(1)) noktasında çizilen");
            label3.setText("teğet doğrusunun denklemi y-2x+1 olarak veriliyor.");
            label4.setText("Buna göre, a.b çarpımı kaçtır?");
            
            radioButton[0].setText("-18");
            radioButton[1].setText("-16");
            radioButton[2].setText("-12");
            radioButton[3].setText("-8");

        }
        if (current == 40) {
            label.setText("41) a bir gerçel sayı olmak üzere,");
            label1.setText("f(x)=ln(2x+8) fonksiyonunun düşey asimptotu ");
            label2.setText("g(x)=sinx/x^2+ax fonksiyonunun da düşey asimptotudur.");
            label3.setText("Buna göre,a kaçtır?");
            label4.setText("");
            
            radioButton[0].setText("1");
            radioButton[1].setText("2");
            radioButton[2].setText("3");
            radioButton[3].setText("4");

        }
        if (current == 41) {
            label.setText("42) 0<x<π/2 olmak üzere,");
            label1.setText("sec(x)-1/2 = 3/sec(x)+1 eşitliği sağlanmaktadır.");
            label2.setText("Buna göre,tan(x)değeri kaçtır?");
            label3.setText("");
            label4.setText("");
            
            radioButton[0].setText("√2");
            radioButton[1].setText("√3");
            radioButton[2].setText("√5");
            radioButton[3].setText("√6");

        }
        if (current == 42) {
            label.setText("43) 0<x<π/2 olmak üzere,");
            label1.setText("sec(x)-1/2 = 3/sec(x)+1 eşitliği sağlanmaktadır.");
            label2.setText("Buna göre,tan(x)değeri kaçtır?");
            label3.setText("");
            label4.setText("");
            
            radioButton[0].setText("3");
            radioButton[1].setText("6");
            radioButton[2].setText("8");
            radioButton[3].setText("11");

        }
        if (current == 43) {
            label.setText("44) Her x gerçel sayısı için A sayısı (4,k=2)∑ cos(2kx)=A");
            label1.setText("şeklinde tanımlanıyor. Buna göre,");
            label2.setText("(4,k=2) ∑cos^2(kx)");
            label3.setText("ifadesinin A türünden eşiti nedir?");
            label4.setText("");
            radioButton[0].setText("A+2");
            radioButton[1].setText("A+4");
            radioButton[2].setText("A+1/2");
            radioButton[3].setText("A+3/2");

        }
        if (current == 44) {
            label.setText("45) Dik koordinat düzleminde orjinden geçen d1,d2 doğruları ile");
            label1.setText("x+y=6 doğrusunun sınırladığı kapalı bölge bir eşkenar üçgendir.");
            label2.setText("Buna göre, bu eşkenar üçgenin alanı kaç birimkaredir?");
            label3.setText("");
            label4.setText("");
            
            radioButton[0].setText("3√3");
            radioButton[1].setText("4√3");
            radioButton[2].setText("6√3");
            radioButton[3].setText("8√3");

        }
        if (current == 45) {
            label.setText("46) Dik koordinat düzleminde (0,10) noktasından geçen bir");
            label1.setText("çember x-eksenine (20,0) noktasında teğettir.");
            label2.setText("Buna göre, bu çemberin yarıçapı kaç birimdir?");
            label3.setText("");
            label4.setText("");
            
            radioButton[0].setText("18");
            radioButton[1].setText("20");
            radioButton[2].setText("21");
            radioButton[3].setText("25");

        }
        if (current == 46) {
            label.setText("47) p pozitif bir gerçel sayı olmak üzere,");
            label1.setText("( x^2 /(p+1)^2 )+ ( y^2 / (p-1)^2 ) =1");
            label2.setText("denklemiyle verilen elipsin odak nokaları arasındaki uzaklık 12 birimdir.");
            label3.setText("Buna göre,bu elipsin asal eksen uzunluğu kaç birimdir?");
            label4.setText("");
            
            radioButton[0].setText("14");
            radioButton[1].setText("15");
            radioButton[2].setText("18");
            radioButton[3].setText("20");

        }
        if (current == 47) {
            label.setText("48) Düzlemde sıfırdan farklı u ve v vektörlerinin toplamı sıfır vektörüne eşit olduğuna göre,");
            label1.setText("1. ||2u-v||=||v||");
            label2.setText("2.  u+3v =(2,-4)ise u=(-1,2)'dir.");
            label3.setText("3.  u ile v arasındaki açı 180 derecedir.");
            label4.setText("ifadelerinden hangileri doğrudur?");
            
            radioButton[0].setText("Yalnız 3");
            radioButton[1].setText("1 ve 2");
            radioButton[2].setText("1 ve 3");
            radioButton[3].setText("2 ve 3");

        }
        if (current == 48) {
            label.setText("49)  Uzayda,");
            label1.setText("d1:x+1=y+2=z/2");
            label2.setText("d2:x/a=y/b=z-c/a");
            label3.setText("doğruları dik kesişmektedir.");
            label4.setText("Buna göre, c kaçtır?");
            
            radioButton[0].setText("9/4");
            radioButton[1].setText("7/3");
            radioButton[2].setText("5/2");
            radioButton[3].setText("3/4");

        }
        if (current == 49) {
            label.setText("50) Ua ve b gerçel sayılar olmak üzere,uzayda(1,1,1)");
            label1.setText("noktasından geçen ax+(a+b)y+(a-b)z=6");
            label2.setText("düzlemi, x+2y-8z=5 düzlemine diktir.");
            label3.setText("Buna göre,a+b toplamı kaçtır?");
            label4.setText("");
            
            radioButton[0].setText("3");
            radioButton[1].setText("4");
            radioButton[2].setText("4");
            radioButton[3].setText("6");

        }
        if (current == 50) { //ayt 2018 soruları başlangıç//
            label.setText("51) a bir gerçel sayı olmak üzere, karmaşık sayılarda");
            label1.setText("(1-ai)/a-i=i");
            label2.setText("eşitliği veriliyor.");
            label3.setText("Buna göre,a kaçtır?");
            label4.setText("");
            
            radioButton[0].setText("3");
            radioButton[1].setText("2");
            radioButton[2].setText("1");
            radioButton[3].setText("0");

        }
        if (current == 51) {
            label.setText("52) x, y ve z birbirinden farklı birer asal sayı olmak üzere,");
            label1.setText("x(z-y)=18");
            label2.setText("y(z-x)=40");
            label3.setText("eşitlikleri veriliyor.");
            label4.setText("Buna göre,x+y+z toplamı kaçtır?");
            
            radioButton[0].setText("17");
            radioButton[1].setText("19");
            radioButton[2].setText("21");
            radioButton[3].setText("23");

        }
        if (current == 52) {
            label.setText("53) Dairesel bir oyun alanında konumları şekilde gösterilen Ali, Büşra, Cem, Deniz ve Ekin isimli beş oyuncu bir topla oyun oynamaktadır.");
            label1.setText("Bu oyunun her seferinde; elinde top bulunan oyuncu, ok yönünde kendinden sonraki üçüncü oyuncuya topu vermektedir. (ALİ,");
            label2.setText("BÜŞRA, DENİZ, CEM) Başlangıçta top Ali'nin elinde bulunmaktadır ve Ali'nin topu Deniz'e vermesiyle oyun başlamıştır.");
            label3.setText("Topu 1. seferde Deniz, 2. seferde Büşra almış ve oyun bu şekilde devam etmiştir.");
            label4.setText("Buna göre, 99. seferde topu kim almıştır?");
            
            radioButton[0].setText("Ali");
            radioButton[1].setText("Büşra");
            radioButton[2].setText("Cem");
            radioButton[3].setText("Deniz");

        }
        if (current == 53) {
            label.setText("54) a, b ve c sıfırdan farklı birer gerçel sayı olmak üzere,");
            label1.setText("p:a+b=0, q:a+c<0, r:c<0 önermeleri veriliyor.");
            label2.setText("(p ^ q)=>r");
            label3.setText("önermesi yanlış olduğuna göre; a, b ve c sayılarının");
            label4.setText("işaretleri sırasıyla aşağıdakilerden hangisidir?");
            
            radioButton[0].setText("-,+,+");
            radioButton[1].setText("-,+,-");
            radioButton[2].setText("-,-,+");
            radioButton[3].setText("+,-,+");

        }
        if (current == 54) {
            label.setText("55) a ve b tam sayılar olmak üzere, gösterimi, a sayısının b sayısını tam böldüğünü ifade eder.");
            label1.setText("Bir öğrenci, a, b ve c tam sayıları ve koşullarını sağlıyorsa koşulunu da sağlar.");
            label2.setText("önermesinin yanlış olduğunu aksine örnek verme yöntemini kullanarak ispatlamak istiyor.");
            label3.setText("Buna göre, öğrencinin verdiği örnek aşağıdakilerden hangisi olabilir?");
            label4.setText("");
            
            radioButton[0].setText("1,3,12");
            radioButton[1].setText("2,4,24");
            radioButton[2].setText("3,2,30");
            radioButton[3].setText("4,5,60");

        }
        if (current == 55) {
            label.setText("56) a ve b sıfırdan farklı gerçel sayılar olmak üzere,");
            label1.setText("gerçel sayılar kümesi üzerinde tanımlı bir f fonksiyonu");
            label2.setText("f(ax+b)=x");
            label3.setText("f(a)=b/a");
            label4.setText("eşitliklerini sağlamaktadır. Buna göre,f(0) değeri kaçtır?");
            
            radioButton[0].setText("-1/2");
            radioButton[1].setText("-1/3");
            radioButton[2].setText("-2/3");
            radioButton[3].setText("1");

        }
        if (current == 56) {
            label.setText("57) Gerçel katsayılı ve baş katsayısı 1 olan 4. dereceden");
            label1.setText("bir P(x) polinomu her x gerçel sayısı için");
            label2.setText("P(x)=P(-x) eşitliğini sağlamaktadır.");
            label3.setText("P(2)=P(3)=0 olduğuna göre,");
            label4.setText("P(1) kaçtır?");
            
            radioButton[0].setText("12");
            radioButton[1].setText("18");
            radioButton[2].setText("24");
            radioButton[3].setText("30");

        }
        if (current == 57) {
            label.setText("58) log₄x ve log₈1/x sayılarının aritmetik ortalaması 1/2'dir.");
            label1.setText("Buna göre , log₁₆x ifadesinin değeri kaçtır?");
            label2.setText("");
            label3.setText("");
            label4.setText("");
            
            radioButton[0].setText("1/2");
            radioButton[1].setText("3/2");
            radioButton[2].setText("5/2");
            radioButton[3].setText("1/4");

        }
        if (current == 58) {
            label.setText("59) Terimleri birbirinden farklı ve ortak farkı r olan bir (an) aritmetik dizisi için");
            label1.setText("a₁=3.r");
            label2.setText(" a₆=a₂.a₄");
            label3.setText("eşitlikleri veriliyor.");
            label4.setText("Buna göre, a₁₀ kaçtır?");
            
            radioButton[0].setText("10");
            radioButton[1].setText("8");
            radioButton[2].setText("6");
            radioButton[3].setText("4");

        }
        if (current == 59) {
            label.setText("60) a ve b pozitif gerçel sayılar olmak üzere,dik koordinat düzleminde orjinden geçen");
            label1.setText("p(x)=(x-a)^2-b parabolü kullanılarak");
            label2.setText(" p(x+a)+b, p(x+a)-b, p(x-a)-b biçiminde tanımlanan üç parabolün tepe noktaları,");
            label3.setText("alanı 16 birimkare olan bir üçgenin köşe noktalarıdır.");
            label4.setText("Buna göre,a+b toplamı kaçtır?");
            
            radioButton[0].setText("6");
            radioButton[1].setText("9");
            radioButton[2].setText("12");
            radioButton[3].setText("15");

        }
        if (current == 60) {
            label.setText("61) m ve n sıfırdan ve birbirinden farklı iki gerçel sayı olmak üzere,");
            label1.setText("x^2+(m+1)x+n-m=0");
            label2.setText("denkleminin köklerinden biri m-n sayısıdır.");
            label3.setText("Buna göre,n/m oranı kaçtır?");
            label4.setText("");
            
            radioButton[0].setText("2");
            radioButton[1].setText("3");
            radioButton[2].setText("4");
            radioButton[3].setText("5");

        }
        if (current == 61) {
            label.setText("62) Engin, birbirinden farklı 3 sesli ve 4 sessiz harfin her birini istediği sayıda kullanarak");
            label1.setText("5 harfli bir palindrom sözcük oluşturacaktır. Bu sözcükte iki sesli harfin yan yana gelmemesi");
            label2.setText("ve iki sessiz harfin de yan yana gelmemesi gerekmektedir.");
            label3.setText("Buna göre,");
            label4.setText("Engin bu koşulları sağlayan kaç farklı palindrom sözcük oluşturabilir?");
            
            radioButton[0].setText("72");
            radioButton[1].setText("84");
            radioButton[2].setText("108");
            radioButton[3].setText("120");

        }
        if (current == 62) {
            label.setText("63) L bir gerçel sayı olmak üzer, gerçel sayılar kümesi üzerinde tanımlı f ve g fonksiyonları için");
            label1.setText("lim f(x)=lim g(x)=L (x->2) Buna göre,");
            label2.setText("1. f(2)=g(2)");
            label3.setText("2. lim f(x)-g(x)=0 (x->2)");
            label4.setText("3. lim f(x)/g(x)=1 (x->2) ifadelerinden hangileri her zaman doğrudur?");
            
            radioButton[0].setText("Yalnız 1");
            radioButton[1].setText("Yalnız 2");
            radioButton[2].setText("1 ve 3");
            radioButton[3].setText("2 ve 3");

        }
        if (current == 63) {
            label.setText("64)         | 10-x^2   ,     x<0");
            label1.setText("     f(x)= |ax+b      ,   0≤x≤3");
            label2.setText("           |(1-x)^2   ,     x>3 ");
            label3.setText("fonksiyonu gerçel sayılar kümesi üzerinde süreklidir.");
            label4.setText("Buna göre,a+b toplamı kaçtır?");
            
            radioButton[0].setText("16");
            radioButton[1].setText("15");
            radioButton[2].setText("12");
            radioButton[3].setText("8");

        }
        if (current == 64) {
            label.setText("65) f(x)=e^x.cosx fonksiyonunun 16.mertebeden türevi");
            label1.setText("olan f^(16)(x) ifadesinin x=0 noktasındaki değeri kaçtır?");
            label2.setText("");
            label3.setText("");
            label4.setText("");
            
            radioButton[0].setText("32");
            radioButton[1].setText("64");
            radioButton[2].setText("128");
            radioButton[3].setText("252");

        }
        if (current == 65) {
            label.setText("66) a, b ve c gerçel sayılar olmak üzere,");
            label1.setText("y=a/x+a eğrisine noktasında teğet olan doğrunun denklemi y=(-x/8)+c biçiminde veriliyor.");
            label2.setText("Buna göre,a+b+c toplamı kaçtır?");
            label3.setText("");
            label4.setText("");
            
            radioButton[0].setText("7/4");
            radioButton[1].setText("11/4");
            radioButton[2].setText("13/4");
            radioButton[3].setText("2");

        }
        if (current == 66) {
            label.setText("67) Bir internet şirketi en fazla 1000 müşteriye hizmet verebilmekte ve aylık internet ücretini 40 TL olarak");
            label1.setText("belirlediğinde bu sayıya ulaşabilmektedir. Bu şirket aylık internet ücretinde yaptığı");
            label2.setText("her 5 TL’lik artış sonrasında müşteri sayısında 50 azalma olduğunu gözlemlemiştir.");
            label3.setText("Bu şirket, aylık internet ücretinden elde edeceği toplam gelirin ");
            label4.setText("en fazla olması için aylık internet ücretini kaç TL olarak belirlemelidir?");
            
            radioButton[0].setText("55");
            radioButton[1].setText("60");
            radioButton[2].setText("65");
            radioButton[3].setText("70");

        }
        if (current == 67) {
            label.setText("68) Gerçel sayılar kümesi üzerinde tanımlı, artan ve sürekli bir f fonksiyonu için");
            label1.setText("f(0)=2, f(1)=3, f(2)=4 eşitlikleri verilmiştir.");
            label2.setText("                 2");
            label3.setText("Buna göre, ∫ f(x)dx integralinin değeri aşağıdakilerden hangisi olabilir?");
            label4.setText("                 0");
            
            radioButton[0].setText("4");
            radioButton[1].setText("4,5");
            radioButton[2].setText("6");
            radioButton[3].setText("7,5");

        }
        if (current == 68) {
            label.setText("69) Bir matematik dersinde kısmi integrasyon konusunu işleyen Ebru Öğretmen tahtaya ∫udv=uv-∫vdu kuralını yazdıktan sonra,");
            label1.setText("Mehmet bir sorunun çözümünde u ve v yerine sırasıyla f(x) ve g(x) fonksiyonlarını seçip bu kuralı uygulayarak");
            label2.setText("∫f(x)g'(x)dx=f(x)/x -∫2/x^2dx eşitliğini elde ediyor.");
            label3.setText("f(1)=2 olduğuna göre, f(e) değeri kaçtır?");
            label4.setText("");
            
            radioButton[0].setText("2");
            radioButton[1].setText("4");
            radioButton[2].setText("6");
            radioButton[3].setText("8");

        }
        if (current == 69) {
            label.setText("70) a ve b pozitif gerçel sayılar olmak üzere, dik koordinat düzleminde y=ax^2+b eğrisi ile");
            label1.setText("x=0 ,x=2 ve y=0 ve doğruları arasında");
            label2.setText("kalan bölge, (2,0) ve (0,b) noktalarından geçen");
            label3.setText("doğru ile alanları oranı 3 olan iki bölgeye ayrılıyor.");
            label4.setText("Buna göre, a/b oranı kaçtır?");
            
            radioButton[0].setText("1/2");
            radioButton[1].setText("2/3");
            radioButton[2].setText("3/4");
            radioButton[3].setText("4/5");

        }
        if (current == 70) {
            label.setText("71) cot(34).sin(44) / sin(22).sin(56)");
            label1.setText("ifadesinin eşiti aşağıdakilerden hangisidir?");
            label2.setText("");
            label3.setText("");
            label4.setText("");
            
            radioButton[0].setText("2cot(22)");
            radioButton[1].setText("2cos(56)");
            radioButton[2].setText("4sin(44)");
            radioButton[3].setText("4cos(34)");

        }
        if (current == 71) {
            label.setText("72) 0<x<π olmak üzere,");
            label1.setText("sinx.cosx/sinx+cosx = sinx-cosx/2");
            label2.setText("eşitliğini sağlayan x değerlerinin toplamı kaçtır?");
            label3.setText("");
            label4.setText("");
            
            radioButton[0].setText("π/2");
            radioButton[1].setText("5π/4");
            radioButton[2].setText("7π/4");
            radioButton[3].setText("π");

        }
        if (current == 72) {
            label.setText("73) Dik koordinat düzleminde; bir köşesi orijinde, diğer");
            label1.setText("köşeleri ise y=x ve y=-x doğruları üzerinde olan");
            label2.setText("bir üçgenin kenarortayları (2,4) noktasında kesişmektedir.");
            label3.setText("Buna göre, bu üçgenin alanı kaç birimkaredir?");
            label4.setText("");
            
            radioButton[0].setText("18");
            radioButton[1].setText("24");
            radioButton[2].setText("27");
            radioButton[3].setText("9√2");

        }
        if (current == 73) {
            label.setText("74) Dik koordinat düzleminde birinin merkezi (12,0) noktası,");
            label1.setText("diğerinin merkezi ise (0,9) noktası olan iki");
            label2.setText("çember sadece (4,6) noktasında kesişmektedir.");
            label3.setText("Bu çemberlerin orijine en yakın olan noktaları");
            label4.setText("arasındaki uzaklık kaç birimdir?");
            
            radioButton[0].setText("√5");
            radioButton[1].setText("√10");
            radioButton[2].setText("√13");
            radioButton[3].setText("2√5");

        }
        if (current == 74) {
            label.setText("75) Dik koordinat düzleminde,u₁=(3,4) ve u₂=(8,-6) vektörleri veriliyor.");
            label1.setText("Bu düzlemde alınan bir v vektörünün, u₁ vektörü üzerine dik izdüşüm vektörü");
            label2.setText("3 birim, u₂ vektörü üzerine dik izdüşüm vektörü ise 1 birim uzunluğundadır.");
            label3.setText("Buna göre, v vektörünün uzunluğu kaç birimdir?");
            label4.setText("");
            
            radioButton[0].setText("√5");
            radioButton[1].setText("√10");
            radioButton[2].setText("5√5");
            radioButton[3].setText("5");

        }
        if (current == 75) {
            label.setText("76) Ayrıt uzunluğu 1 birim olan 3 adet küp, her birinin en az bir yüzü diğer bir küpün");
            label1.setText("bir yüzüyle tam örtüşecek biçimde birbirine yapıştırılıyor.");
            label2.setText("Buna göre, bu şekilde elde edilebilecek bir cismin");
            label3.setText("seçilen iki köşesi arasındaki uzaklık birim türünden aşağıdakilerden hangisi olamaz?");
            label4.setText("");
            
            radioButton[0].setText("√7");
            radioButton[1].setText("√8");
            radioButton[2].setText("√9");
            radioButton[3].setText("√10");

        }
        if (current == 76) { //2019 ayt 
            label.setText("77) Karmaşık sayılar kümesinde");
            label1.setText("(4-2i).(6+3i)/(1-i).(1+i)");
            label2.setText("işleminin sonucu kaçtır?");
            label3.setText("");
            label4.setText("");
            
            radioButton[0].setText("15");
            radioButton[1].setText("12");
            radioButton[2].setText("10");
            radioButton[3].setText("9");

        }
        if (current == 77) {
            label.setText("78) A,B ve C sıfırdan ve birbirinden farklı birer rakam olmak üzere,");
            label1.setText("ABC, CAB, BCA ");
            label2.setText("üç basamaklı doğal sayıları sırasıyla 4,5 ve 9 ile tam bölünmektedir.");
            label3.setText("Buna göre, A.B.C çarpımı kaçtır?");
            label4.setText("");
            
            radioButton[0].setText("150");
            radioButton[1].setText("180");
            radioButton[2].setText("200");
            radioButton[3].setText("210");

        }
        if (current == 78) {
            label.setText("79) 123 sayısına sırasıyla aşağıdaki adımlar uygulanarak rakamlarının yerleri değiştiriliyor ve her adımda tekrar üç basamaklı bir sayı elde ediliyor.");
            label1.setText("• 1. adımda, sayının onlar ve yüzler basamağındaki rakamların yerleri değiştirilerek bir sayı elde ediliyor.");
            label2.setText("• 2. adımda, bir önceki adımda elde edilen sayının birler ve onlar basamağındaki rakamların yerleri değiştirilerek bir sayı elde ediliyor.");
            label3.setText("Bu şekilde devam edilerek,adım numarası tek sayı ise bir önceki adımda elde edilen sayının onlar ve yüzler, adım numarası çift sayı ise bir önceki adımda elde edilen");
            label4.setText("sayının birler ve onlar basamağındaki rakmaların yerleri değiştirilerek sayılar elde ediliyor. Buna göre,75. adım sonunda elde edilen sayı aşağıdakilerden hangisidir?");
            
            radioButton[0].setText("321");
            radioButton[1].setText("312");
            radioButton[2].setText("231");
            radioButton[3].setText("231");

        }
        if (current == 79) {
            label.setText("80) Bir masada;biri kırmızı, biri mavi ve biri sarı renkli olmak üzere toplam üç bilye bulunmaktadır. Bu bilyeler A,B ve C torbalarına her bir torbada bir bilye olacak");
            label1.setText("şekilde konuluyor ve p:\"A torbasında kırmızı bilye yoktur. q:\"B torbasında mavi bilye vardır. ");
            label2.setText("r:\"C torbasında sarı bilye yoktur. önermeleri veriliyor. p⋀(q⋁r)'\n");
            label3.setText("önermesi doğru olduğuna göre; A,B ve C torbalarında");
            label4.setText("bulunan bilyelerin renkleri sırasıyla aşağıdakilerden hangisidir?");
            
            radioButton[0].setText("Kırmızı-Mavi-Sarı");
            radioButton[1].setText("Mavi-Kırmızı-Sarı");
            radioButton[2].setText("Mavi-Sarı-Kırmızı");
            radioButton[3].setText("Sarı-Kırmızı-Mavi");

        }
        if (current == 80) {
            label.setText("81) Matematik dersinde,Canan sırasıyla aşağıdaki adımları takip ederek işlemler yapmıştır.");
            label1.setText("I.adım:6=1.2.3=e^ln1.e^ln2.e^ln3, II.adım:e^ln1.e^ln2.e^ln3 = e^ln1+ln2+ln3, III.adım:e^ln1+ln2+ln3=e^ln6");
            label2.setText("IV.adım:e^ln6=e^ln(2+4),VI.adım:e^ln2+ln4=e^ln2.e^ln4, VII.adım:e^ln2.e^ln4=2.4=8 ");
            label3.setText("Bu adımlar sonunda Canan, 6=8 sonucunu elde etmiştir.");
            label4.setText("Buna göre,Canan numaraladırılmış adımların hangisinde hata yapmıştır?");
            
            radioButton[0].setText("I");
            radioButton[1].setText("III");
            radioButton[2].setText("IV");
            radioButton[3].setText("V");

        }
        if (current == 81) {
            label.setText("82) Gerçel sayılar kümesi üzerinde tanımlı bir f fonksiyonu\n");
            label1.setText("her x ve y gerçel sayısı için");
            label2.setText("f(x+y)=f(x)+f(y) eşitliğini sağlamaktadır.");
            label3.setText("f(2)-f(1)=10 olduğuna göre,");
            label4.setText("f(3).f(4)/f(5) işleminin sonucu kaçtır?");
            
            radioButton[0].setText("16");
            radioButton[1].setText("18");
            radioButton[2].setText("21");
            radioButton[3].setText("24");

        }
        if (current == 82) {
            label.setText("83) a bir gerçel sayı olmak üzere,x+1≤a eşitliği ile ilgili aşağıdakiler bilinmektedir.");
            label1.setText("• x=0 bu eşitsizliği sağlar.");
            label2.setText("• x=4 bu eşitsizliği sağlamaz.");
            label3.setText("Buna göre,a sayısının alabileceği değerleri ifade eden");
            label4.setText("en geniş aralık aşağıdakilerden hangisidir?");
            
            radioButton[0].setText("[0,4)");
            radioButton[1].setText("[1,4]");
            radioButton[2].setText("(1,5]");
            radioButton[3].setText("[1,5");

        }
        if (current == 83) {
            label.setText("84) Birbirinden farklı a,b ve c gerçel sayıları için");
            label1.setText("a+b=|a|");
            label2.setText("b+c=|b|");
            label3.setText("eşitlikleri veriliyor.");
            label4.setText("Buna göre;a,b ve c sayılarının doğru sıralanışı aşağıdakilerden hangisidir?");
            
            radioButton[0].setText("a<b<c");
            radioButton[1].setText("a<c<b");
            radioButton[2].setText("b<a<c");
            radioButton[3].setText("b<c<a");

        }
        if (current == 84) {
            label.setText("85) En yüksek dereceli terimin katsayısı 1 olan ikinci");
            label1.setText("dereceden gerçel katsayılı bir P(x) polinomunun iki");
            label2.setText("farklı kökü P(0) P(-1) değerleridir.");
            label3.setText("Buna göre, P(2) değeri kaçtır?");
            label4.setText("");
            
            radioButton[0].setText("1/2");
            radioButton[1].setText("3/2");
            radioButton[2].setText("5/2");
            radioButton[3].setText("1");

        }
        if (current == 85) {
            label.setText("86) x sayısı, 1'den büyük bir tam sayı olmak üzere,");
            label1.setText("• 64/x oranının bir tam sayı olduğu,");
            label2.setText("• ln64/lnx oranının bir tam sayı olmadığı veriliyor.");
            label3.setText("Buna göre, x'in alabileceği değerler toplamı kaçtır?");
            label4.setText("");
            
            radioButton[0].setText("40");
            radioButton[1].setText("42");
            radioButton[2].setText("48");
            radioButton[3].setText("54");

        }
        if (current == 86) {
            label.setText("87) Ada,kullandığı bilimsel bir hesap makinesinde n⋜23 olmak üzere, her n pozitif tam sayı için log₂n");
            label1.setText("değerini hesaplıyor ve her bir değerin tam sayı ya da ondalıklı sayı olduğunu görüyor.");
            label2.setText("Ada;ekranda görünen değer tam sayı ise o sayıyı, ondalıklı sayı ise o sayının tam ksımını bir kağıda");
            label3.setText("yazdıktan sonra yazdığı bu sayıların toplamını buluyor.");
            label4.setText("Buna göre,Ada'nın bulduğu toplamın sonucu kaçtır?");
            
            radioButton[0].setText("94");
            radioButton[1].setText("97");
            radioButton[2].setText("100");
            radioButton[3].setText("103");

        }
        if (current == 87) {
            label.setText("88) Herhangi ardışık 3 teriminin toplamı birbirine eşit olan bir An dizisi için");
            label1.setText("a₂+a₃=a₄=2 eşitliği sağlanmaktadır.");
            label2.setText("Buna göre,");
            label3.setText("a₁+a₂+...+a₂₅");
            label4.setText("toplamının sonucu kaçtır?");
            
            radioButton[0].setText("34");
            radioButton[1].setText("35");
            radioButton[2].setText("36");
            radioButton[3].setText("37");

        }
        if (current == 88) {
            label.setText("89) A ve B rakamlardan oluşan boştan farklı birer küme olmak üzere,");
            label1.setText("A⋂B= A⋂{0,2,4,6,8} eşitliği sağlanıyorsa A kümesine B kümesinin ortakesişim kümesi denir.");
            label2.setText("A kümesi, b={0,1,2,3,4}");
            label3.setText("kümesinin ortakesişim kümesi olduğuna göre,");
            label4.setText("kaç farklı A kümesi vardır?");
            
            radioButton[0].setText("7");
            radioButton[1].setText("15");
            radioButton[2].setText("31");
            radioButton[3].setText("63");

        }
        if (current == 89) {
            label.setText(" 90) Ege'nin çantasında boyutları aynı olan kimlik kartı,öğrenci kartı,yemek kartı ve otobüs kartı olmak üzere");
            label1.setText("dört kart bulunmaktadır.Ege,otboüs kartını bulmak için çantasından rastgele bir kart çıkartıyor.");
            label2.setText("Yanlış kartı çıkartmışsa onu elinde tutarak çantasından rastgele");
            label3.setText("bir kart daha çıkartıyor ve otobüs kartını bulana kadar bu şekilde devam ediyor.");
            label4.setText("Ege'nin otobüs kartını üçüncü denemede bulma olasılığı kaçtır?");
            
            radioButton[0].setText("1/4");
            radioButton[1].setText("1/8");
            radioButton[2].setText("3/8");
            radioButton[3].setText("1/16");

        }
        if (current == 90) {
            label.setText("91) Gerçel sayılar kümesinin bir alt kümesi üzerinde bir f fonksiyonu");
            label1.setText("f(x)=x^2-4x+4/x-2 + x^2-6x+9/2x-6 biçiminde tanımlanıyor. Buna göre,");
            label2.setText("lim f(x)x→2 + lim f(x)x→3");
            label3.setText("ifadesinin değeri kaçtır?");
            label4.setText("");
            
            radioButton[0].setText("3/2");
            radioButton[1].setText("1/2");
            radioButton[2].setText("4/3");
            radioButton[3].setText("3/4");

        }
        if (current == 91) {
            label.setText("92) a bir gerçek sayı olmak üzere, gerçel sayılar kümesi üzerinde bir f fonksiyonu");
            label1.setText("        ╭  a-x         ,     x<1");
            label2.setText(" f(x)= ˂  5x-4        ,    1≤x≤5");
            label3.setText("        ╰ (x-a)^2+12   ,     x>5");
            label4.setText("biçiminde tanımlanıyor. f fonksiyonunun sürekli olmadığı yalnızca bir nokta olduğuna göre, f(7)-f(0) ifadesinin değeri kaçtır?");
            
            radioButton[0].setText("3");
            radioButton[1].setText("4");
            radioButton[2].setText("5");
            radioButton[3].setText("6");

        }
        if (current == 92) {
            label.setText("93) k bir gerçek sayı olmak üzere, gerçel sayılar kümesinin birer alt kümesi üzerinde tanımlı ve türevlenebilir f ve g fonksiyonları için");
            label1.setText("f(x)=g(x^2)+kx^3 eşitliği sağlanmaktadır.");
            label2.setText("f'(-1)=g'(1)=2");
            label3.setText("olduğuna göre,k kaçtır??");
            label4.setText("");
            
            radioButton[0].setText("2");
            radioButton[1].setText("1");
            radioButton[2].setText("0");
            radioButton[3].setText("-1");

        }
        if (current == 93) {
            label.setText("94) Gerçel sayılar kümesi üzerinde bir f fonksiyonu f(x)=x^2+x-4 biçiminde tanımlanıyor.");
            label1.setText("Gerçel sayılar kümesi üzerinde tanımlı ve sürekli bir g fonksiyonunun türevi olan g'fonksiyonu g'(x)=0");
            label2.setText("eşitliğini yalnızca x=2 değeri için sağlamaktadır. Buna göre,");
            label3.setText("(g ○ f)'(x)=0");
            label4.setText("eşitliğini sağlayan x değerlerinin çarpımı kaçtır?");
            
            radioButton[0].setText("0");
            radioButton[1].setText("1");
            radioButton[2].setText("3");
            radioButton[3].setText("4");

        }
        if (current == 94) {
            label.setText("95) Dik koordinat düzleminde,f(x)=x^2 + ax fonksiyonunun");
            label1.setText("grafiğine (2,f(2)) noktasından çizilen teğet doğrusu,");
            label2.setText("g(x)=bx^3 fonksiyonunun grafiğine (1,g(1)) noktasında teğettir.");
            label3.setText("Buna göre,a.b çarpımı kaçtır?");
            label4.setText("");
            
            radioButton[0].setText("2");
            radioButton[1].setText("4");
            radioButton[2].setText("6");
            radioButton[3].setText("8");

        }
        if (current == 95) {
            label.setText("96) a∈(π/12,π/6) olmak üzere");
            label1.setText("x=sin(3a)");
            label2.setText("y=cos(3a)");
            label3.setText("z=tan(3a)");
            label4.setText("sayılarının doğru sıralanışı aşağıdakilerden hangisidir?");
            
            radioButton[0].setText("x<y<z");
            radioButton[1].setText("x<z<y");
            radioButton[2].setText("y<x<z");
            radioButton[3].setText("y<z<x");

        }
        if (current == 96) {
            label.setText("97) 0<x<π/2 olmak üzere");
            label1.setText("secx.tanx.(1-sinx)=1/4");
            label2.setText("olduğuna göre,cscx değeri kaçtır?");
            label3.setText("");
            label4.setText("");
            
            radioButton[0].setText("5/2");
            radioButton[1].setText("7/2");
            radioButton[2].setText("2");
            radioButton[3].setText("3");

        }
        if (current == 97) {
            label.setText("98) m bir gerçel sayı olmak üzere, dik koordinat düzleminde");
            label1.setText("•(0,1) noktasından geçen bir doğrunun eğiminin m,");
            label2.setText("•(0,0) noktasından geçen bir doğrunun eğiminin 2m,");
            label3.setText("•(1,0) noktasından geçen bir doğrunun eğiminin 3m");
            label4.setText("olduğu ve bu üç doğrunun bir noktada kesiştiği bilinmektedir. Buna göre, m değeri kaçtır?");
            
            radioButton[0].setText("1/2");
            radioButton[1].setText("1/3");
            radioButton[2].setText("3/4");
            radioButton[3].setText("3/5");

        }
        if (current == 98) {
            label.setText("99) Dik koordinat düzleminde,x+y=4 doğrusu ile");
            label1.setText("iki eş parçaya ayrılan çember x-eksenini tek noktada,");
            label2.setText("y-eksenini ise iki farklı noktada kesmektedir.");
            label3.setText("Çemberin y-eksenini kestiği noktalar arasındaki");
            label4.setText("uzaklık 4 birim olduğuna göre,çemberin çevresi kaç birimdir?");
            
            radioButton[0].setText("4π");
            radioButton[1].setText("5π");
            radioButton[2].setText("6π");
            radioButton[3].setText("7π");

        }
        if (current == 99) {
            label.setText("100) Düzlemde bir ABC dik üçgeninnin köşe noktalarını merkez kabul eden ve birbirini");
            label1.setText("kesmeyen r yarıçaplı üç daire oluşturuluyor.Üçgenin kenarları üzerinde olup");
            label2.setText("bu dairelerin içinde kalmayan parçaların uzunlukları 2 birim, 3 birim ve 5 birim olarak veriliyor.");
            label3.setText("Buna göre,dairelerin içinde olup üçgenin dışında kalan");
            label4.setText("bölgelerin alanları toplamı kaç birimkaredir?");
            
            radioButton[0].setText("8π");
            radioButton[1].setText("9π");
            radioButton[2].setText("9π/2");
            radioButton[3].setText("15π/2");

        }
        if (current == 100) {
            label.setText("101) Dik koordinat düzleminde bir P(a,b) noktası orjin etrafında saat yönünün tersine 90°");
            label1.setText("döndürüldükten sonra elde edilen nokta;x-ekseni boyunca pozitif yönde");
            label2.setText("3 birim,y-ekseni boyunca pozitif yönde 1 birim");
            label3.setText("ötelendiğinde yine P(a,b)noktası elde ediliyor.");
            label4.setText("Buna göre,a.b çarpımı kaçtır?");
            
            radioButton[0].setText("0");
            radioButton[1].setText("1");
            radioButton[2].setText("2");
            radioButton[3].setText("3");

        }
        if (current == 101) { //2020 AYT //
            label.setText("102) Aşağıdaki kutuların içine 1’den 9’a kadar olan tam sayılardan 6 tanesi her kutuya");
            label1.setText("farklı bir sayı gelecek şekilde yerleştirildiğinde tüm eşitlikler sağlanmaktadır.");
            label2.setText("□+□=5 , □-□=5 , □﹕□=5 ");
            label3.setText("Buna göre, kullanılmayan tam sayıların toplamı kaçtır?");
            label4.setText("");
            
            radioButton[0].setText("23");
            radioButton[1].setText("21");
            radioButton[2].setText("19");
            radioButton[3].setText("17");

        }
        if (current == 102) {
            label.setText("103) a, b ve c asal sayılar olmak üzere,");
            label1.setText("a(a+b)=c(c-b)=143");
            label2.setText("eşitlikleri veriliyor.");
            label3.setText("Buna göre, a+b+c toplamı kaçtır?");
            label4.setText("");
            
            radioButton[0].setText("22");
            radioButton[1].setText("26");
            radioButton[2].setText("30");
            radioButton[3].setText("32");

        }
        if (current == 103) {
            label.setText("104) x ve y tam sayıları için");
            label1.setText("9^x-3^2x-2=2^y.3^6 eşitliği sağlanmaktadır.");
            label2.setText("Buna göre, x+y toplamı kaçtır?");
            label3.setText("");
            label4.setText("");
            
            radioButton[0].setText("4");
            radioButton[1].setText("5");
            radioButton[2].setText("6");
            radioButton[3].setText("7");

        }
        if (current == 104) {
            label.setText("105) a, b ve c gerçel sayıları için a-b<0<c<c-b eşitsizliği veriliyor. Buna göre,");
            label1.setText("I. a.b.c>a");
            label2.setText("II.(a+c).b>a");
            label3.setText("III.b-a+c>a");
            label4.setText("ifadelerinden hangileri her zaman doğrudur?");
            
            radioButton[0].setText("Yalnız I");
            radioButton[1].setText("Yalnız II");
            radioButton[2].setText("I ve II");
            radioButton[3].setText("I ve III");

        }
        if (current == 105) {
            label.setText("106) x ve y tam sayılar olmak üzere,");
            label1.setText("|x-3|+|2x+y|+|2x+y-1|=1 eşitliği sağlanmaktadır.");
            label2.setText("Buna göre, y'nin alabileceği değerler toplamı kaçtır?");
            label3.setText("");
            label4.setText("");
            
            radioButton[0].setText("-12");
            radioButton[1].setText("-11");
            radioButton[2].setText("-10");
            radioButton[3].setText("-9");

        }
        if (current == 106) {
            label.setText("107) Üç basamaklı ABA doğal sayısının iki basamaklı");
            label1.setText(" A1 doğal sayısı ile bölümünden elde edilen bölüm 13, kalan ise 19 oluyor.");
            label2.setText("Buna göre, A+B toplamı kaçtır?");
            label3.setText("");
            label4.setText("");
            
            radioButton[0].setText("8");
            radioButton[1].setText("9");
            radioButton[2].setText("10");
            radioButton[3].setText("11");

        }
        if (current == 107) {
            label.setText("108) A,B ve C kümeleriyle ilgili ﹛(1,2),(2,3),(3,4﹜⊆AxB ﹛(1,2),(3,4),(4,2),(4,4)﹜⊆AxB olduğu biliniyor. Buna göre,");
            label1.setText("I. A⋂B kümesi en az 3 elemanlıdır.");
            label2.setText("II. A⋂C kümesi en az 3 elemanlıdır.");
            label3.setText("III. B⋂C kümesi en az 3 elemanlıdır.");
            label4.setText("ifadelerinden hangileri her zaman doğrudur?");
            
            radioButton[0].setText("Yalnız I");
            radioButton[1].setText("Yalnız II");
            radioButton[2].setText("Yalnız III");
            radioButton[3].setText("I ve III");

        }
        if (current == 108) {
            label.setText("109) Her elemanı bir pozitif tam sayı olan bir kümenin eleman sayısı, bu kümenin en küçük elemanının");
            label1.setText("değerinden bir fazla ise bu kümeye geniş küme denir. A, B ve C geniş kümeler olmak üzere,");
            label2.setText("A⋃B⋃C=﹛1,2,3,4,5,6,7,8,9﹜, A⋂B=﹛3﹜");
            label3.setText("1∈A, 6∈B olduğu biliniyor.");
            label4.setText("Buna göre, C kümesi aşağıdakilerden hangisidir?");
            
            radioButton[0].setText("﹛1,2﹜");
            radioButton[1].setText("﹛3,4,8,9﹜");
            radioButton[2].setText("﹛3,5,7,8﹜");
            radioButton[3].setText("﹛4,5,6,7,8﹜");

        }
        if (current == 109) {
            label.setText("110)Karmaşık sayılar kümesinde");
            label1.setText("i.(2-i).(2-4i)/(1-i).(1+i) işleminin sonucu kaçtır?");
            label2.setText("");
            label3.setText("");
            label4.setText("");
            
            radioButton[0].setText("2");
            radioButton[1].setText("5");
            radioButton[2].setText("10");
            radioButton[3].setText("2i");

        }
        if (current == 110) {
            label.setText("111) a ve b sıfırdan farklı birer tam sayı olmak üzere, gerçel");
            label1.setText("sayılar kümesi üzerinde bir f fonksiyonu");
            label2.setText("biçiminde tanımlanıyor.");
            label3.setText("olduğuna göre, değeri kaçtır?");
            label4.setText("");
            
            radioButton[0].setText("7");
            radioButton[1].setText("8");
            radioButton[2].setText("9");
            radioButton[3].setText("10");

        }
        if (current == 111) {
            label.setText("112) P(x)ve Q(x)sabit olmayan birer polinom, R(x) ise birinci dereceden bir polinom olmak üzere,P(x)=Q(x).R(x) eşitliği sağlanmaktadır. Buna göre,");
            label1.setText("I. P(x)ve polinomlarının sabit terimleri aynıdır.");
            label2.setText("II. ’in grafiği bir parabol ise ’in grafiği bir doğrudur.");
            label3.setText("III. polinomunun her kökü polinomunun da bir köküdür.");
            label4.setText("ifadelerinden hangileri her zaman doğrudur?");
            
            radioButton[0].setText("Yalnız III");
            radioButton[1].setText("I ve II");
            radioButton[2].setText("I ve III");
            radioButton[3].setText("II ve III");

        }
        if (current == 112) {
            label.setText("113) Her birinin en yüksek dereceli teriminin katsayısı 1 olan");
            label1.setText("üçüncü dereceden gerçel katsayılı P(x) ve R(x)");
            label2.setText("polinomları için 2 ve 6 ortak köklerdir. P(x)-R(x)");
            label3.setText("polinomu ile bölündüğünde kalan 10 olmaktadır.");
            label4.setText("Buna göre, P(0)-R(0) değeri kaçtır?");
            
            radioButton[0].setText("24");
            radioButton[1].setText("27");
            radioButton[2].setText("30");
            radioButton[3].setText("33");

        }
        if (current == 113) {
            label.setText("114) m ve n tam sayılar olmak üzere,");
            label1.setText("(x^2+2y)^7");
            label2.setText("ifadesinin açılımında terimlerden biri mx^n.y^2 olduğuna göre, m+n toplamı kaçtır?");
            label3.setText("");
            label4.setText("");
            
            radioButton[0].setText("64");
            radioButton[1].setText("72");
            radioButton[2].setText("86");
            radioButton[3].setText("94");

        }
        if (current == 114) {
            label.setText("115) a ve b pozitif gerçel sayılar olmak üzere,");
            label1.setText("2ax^2-5bx+8b=⍺");
            label2.setText("denkleminin kökleri a ve b’dir.");
            label3.setText("Buna göre, a+b toplamı kaçtır?");
            label4.setText("");
            
            radioButton[0].setText("5");
            radioButton[1].setText("6");
            radioButton[2].setText("10");
            radioButton[3].setText("12");

        }
        if (current == 115) {
            label.setText("116) Bir çubuk eşit uzunlukta 4 parçaya bölündüğünde her bir");
            label1.setText("parçanın uzunluğu log₅(x) birim, eşit uzunlukta");
            label2.setText("10 parçaya bölündüğünde her bir parçanın uzunluğu");
            label3.setText("log₅(x^2/25) birim olmaktadır.");
            label4.setText("Buna göre, çubuğun uzunluğu kaç birimdir?");
            
            radioButton[0].setText("5");
            radioButton[1].setText("8");
            radioButton[2].setText("10");
            radioButton[3].setText("12");

        }
        if (current == 116) {
            label.setText("117) n bir tam sayı ve 1<n<100 olmak üzere,");
            label1.setText("log₂(log₃n)");
            label2.setText("ifadesinin değeri bir pozitif tam sayıya eşittir.");
            label3.setText("Buna göre, n sayısının alabileceği değerler toplamı kaçtır?");
            label4.setText("");
            
            radioButton[0].setText("45");
            radioButton[1].setText("63");
            radioButton[2].setText("72");
            radioButton[3].setText("90");

        }
        if (current == 117) {
            label.setText("118) 5 Ekim 2020 Pazartesi ile 18 Ekim 2020 Pazar günleri");
            label1.setText("arasındaki günler ve bu iki gün de dahil olmak üzere,");
            label2.setText("bu 14 gün içinden iki farklı günde birer toplantı yapılacaktır.");
            label3.setText("Toplantılardan en az biri hafta içi olacak biçimde bir ");
            label4.setText("düzenleme yapılmak istendiğine göre, bu dü zenleme kaç farklı şekilde yapılabilir?");
            
            radioButton[0].setText("70");
            radioButton[1].setText("75");
            radioButton[2].setText("80");
            radioButton[3].setText("85");

        }
        if (current == 118) {
            label.setText("119) Sözel ve sayısal bölümlerinde 4’er soru olmak üzere toplam 8 sorudan oluşan bir sınavın kitapçığında");
            label1.setText("“Sınavı geçmek için sözel ve sayısal bölümlerin her birinden en az 2’şer soru olmak üzere");
            label2.setText("toplam en az 5 soruyu doğru cevaplamalısınız.” ifadesi yer almaktadır.");
            label3.setText("Bu ifadeyi eksik okuyan Sevcan, sınavdaki 8 sorudan rastgele 5’ini seçmiş ve");
            label4.setText("seçtiği her bir soruyu doğru cevaplamıştır. Buna göre, Sevcan’ın sınavı geçme olasılığı kaçtır?");
            
            radioButton[0].setText("3/4");
            radioButton[1].setText("4/5");
            radioButton[2].setText("5/6");
            radioButton[3].setText("6/7");

        }
        if (current == 119) {
            label.setText("120) 2tanx-sin(2x)/sin^2.x");
            label1.setText("ifadesinin sadeleştirilmiş biçimi aşağıdakilerden hangisidir?");
            label2.setText("");
            label3.setText("");
            label4.setText("");
            
            radioButton[0].setText("2tanx");
            radioButton[1].setText("tan(2x)");
            radioButton[2].setText("2cosx");
            radioButton[3].setText("cos(2x)");

        }
        if (current == 120) {
            label.setText("121) Dar açılı bir ABC üçgeninin iç açılarının ölçüleri derece");
            label1.setText("türünden x, y ve z olmak üzere, olduğu biliniyor. Buna göre,");
            label2.setText("a= sin(x+y), b= sin(x+z), c= sin(y+z)");
            label3.setText("sayılarının doğru sıralanışı aşağıdakilerden hangisidir?");
            label4.setText("");
            
            radioButton[0].setText("a<b<c");
            radioButton[1].setText("b<a<c");
            radioButton[2].setText("b<c<a");
            radioButton[3].setText("c<a<b");

        }
        if (current == 121) {
            label.setText("122) 0<x<π/2 olmak üzere,");
            label1.setText("1+tanx/cotx . sinx-cosx/sinx = 2 ");
            label2.setText("olduğuna göre, sinx değeri kaçtır?");
            label3.setText("");
            label4.setText("");
            
            radioButton[0].setText("1/8");
            radioButton[1].setText("3/5");
            radioButton[2].setText("√2/2");
            radioButton[3].setText("√3/2");

        }
        if (current == 122) {
            label.setText("123) Dik koordinat düzleminde bir d doğrusunun A(-4,1)");
            label1.setText("noktasından geçtiği ve 2x-y=5 doğrusuna dik olduğu biliniyor.");
            label2.setText("d doğrusunun x-eksenini kestiği nokta (a,0) ve");
            label3.setText("y-eksenini kestiği nokta (0,b) olduğuna göre,");
            label4.setText("a+b toplamı kaçtır ?");
            
            radioButton[0].setText("-3");
            radioButton[1].setText("-1");
            radioButton[2].setText("0");
            radioButton[3].setText("1");

        }
        if (current == 123) {
            label.setText("124) Dik koordinat düzleminde A(2,7) ve B(-1,4) noktaları");
            label1.setText("x-ekseni boyunca pozitif yönde 3 birim ötelenerek");
            label2.setText("sırasıyla D ve C noktaları elde ediliyor.");
            label3.setText("Buna göre köşeleri A,B,C ve D noktaları olan");
            label4.setText("dörtgenin alanı kaç birimkaredir?");
            
            radioButton[0].setText("9");
            radioButton[1].setText("10");
            radioButton[2].setText("11");
            radioButton[3].setText("12");

        }
        label.setBounds(30, 40, 1800, 20);
        label1.setBounds(30, 60, 1800, 20);
        label2.setBounds(30, 80, 1800, 20);
        label3.setBounds(30, 100, 1800, 20);
        for (int i = 0, j = 0; i <= 90; i += 30, j++) {
            radioButton[j].setBounds(50, 200 + i, 200, 20);
        }
    }

    boolean check() {
        if (current == 0) {
            return (radioButton[2].isSelected());
        }
        if (current == 1) {
            return (radioButton[3].isSelected());
        }
        if (current == 2) {
            return (radioButton[2].isSelected());
        }
        if (current == 3) {
            return (radioButton[0].isSelected());
        }
        if (current == 4) {
            return (radioButton[1].isSelected());
        }
        if (current == 5) {
            return (radioButton[0].isSelected());
        }
        if (current == 6) {
            return (radioButton[1].isSelected());
        }
        if (current == 7) {
            return (radioButton[0].isSelected());
        }
        if (current == 8) {
            return (radioButton[3].isSelected());
        }
        if (current == 9) {
            return (radioButton[1].isSelected());
        }
        if (current == 10) {
            return (radioButton[3].isSelected());
        }
        if (current == 11) {
            return (radioButton[1].isSelected());
        }
        if (current == 12) {
            return (radioButton[2].isSelected());
        }
        if (current == 13) {
            return (radioButton[3].isSelected());
        }
        if (current == 14) {
            return (radioButton[3].isSelected());
        }
        if (current == 15) {
            return (radioButton[0].isSelected());
        }
        if (current == 16) {
            return (radioButton[3].isSelected());
        }
        if (current == 17) {
            return (radioButton[1].isSelected());
        }
        if (current == 18) {
            return (radioButton[1].isSelected());
        }
        if (current == 19) {
            return (radioButton[3].isSelected());
        }
        if (current == 20) {
            return (radioButton[3].isSelected());
        }
        if (current == 21) {
            return (radioButton[3].isSelected());
        }
        if (current == 22) {
            return (radioButton[3].isSelected());
        }
        if (current == 23) {
            return (radioButton[2].isSelected());
        }
        if (current == 24) {
            return (radioButton[0].isSelected());
        }
        if (current == 25) {
            return (radioButton[2].isSelected());
        }
        if (current == 26) {
            return (radioButton[1].isSelected());
        }
        if (current == 27) {
            return (radioButton[3].isSelected());
        }
        if (current == 28) {
            return (radioButton[1].isSelected());
        }
        if (current == 29) {
            return (radioButton[2].isSelected());
        }
        if (current == 30) {
            return (radioButton[2].isSelected());
        }
        if (current == 31) {
            return (radioButton[1].isSelected());
        }if (current == 32) {
            return (radioButton[3].isSelected());
        }if (current == 33) {
            return (radioButton[1].isSelected());
        }if (current == 34) {
            return (radioButton[0].isSelected());
        }if (current == 35) {
            return (radioButton[2].isSelected());
        }if (current == 36) {
            return (radioButton[0].isSelected());
        }if (current == 37) {
            return (radioButton[1].isSelected());
        }if (current == 38) {
            return (radioButton[0].isSelected());
        }if (current == 39) {
            return (radioButton[2].isSelected());
        }if (current == 40) {
            return (radioButton[3].isSelected());
        }if (current == 41) {
            return (radioButton[3].isSelected());
        }if (current ==42) {
            return (radioButton[2].isSelected());
        }if (current == 43) {
            return (radioButton[3].isSelected());
        }if (current == 44) {
            return (radioButton[2].isSelected());
        }if (current == 45) {
            return (radioButton[3].isSelected());
        }if (current == 46) {
            return (radioButton[3].isSelected());
        }if (current == 47) {
            return (radioButton[3].isSelected());
        }if (current == 48) {
            return (radioButton[0].isSelected());
        }if (current == 49) {
            return (radioButton[0].isSelected());
        }if (current == 50) {
            return (radioButton[3].isSelected());
        }if (current == 51) {
            return (radioButton[1].isSelected());
        }if (current == 52) {
            return (radioButton[2].isSelected());
        }if (current == 53) {
            return (radioButton[0].isSelected());
        }if (current == 54) {
            return (radioButton[3].isSelected());
        }if (current == 55) {
            return (radioButton[0].isSelected());
        }if (current == 56) {
            return (radioButton[2].isSelected());
        }if (current == 57) {
            return (radioButton[1].isSelected());
        }if (current == 58) {
            return (radioButton[3].isSelected());
        }if (current == 59) {
            return (radioButton[0].isSelected());
        }if (current == 60) {
            return (radioButton[0].isSelected());
        }if (current == 61) {
            return (radioButton[1].isSelected());
        }if (current == 62) {
            return (radioButton[1].isSelected());
        }if (current == 63) {
            return (radioButton[0].isSelected());
        }if (current == 64) {
            return (radioButton[3].isSelected());
        }if (current == 65) {
            return (radioButton[2].isSelected());
        }if (current == 66) {
            return (radioButton[3].isSelected());
        }if (current == 67) {
            return (radioButton[2].isSelected());
        }if (current == 68) {
            return (radioButton[1].isSelected());
        }if (current == 69) {
            return (radioButton[2].isSelected());
        }if (current == 70) {
            return (radioButton[3].isSelected());
        }if (current == 71) {
            return (radioButton[1].isSelected());
        }if (current == 72) {
            return (radioButton[2].isSelected());
        }if (current == 73) {
            return (radioButton[3].isSelected());
        }if (current == 74) {
            return (radioButton[1].isSelected());
        }if (current == 75) {
            return (radioButton[0].isSelected());
        }if (current == 76) {
            return (radioButton[0].isSelected());
        }if (current == 77) {
            return (radioButton[3].isSelected());
        }if (current == 78) {
            return (radioButton[0].isSelected());
        }if (current == 79) {
            return (radioButton[1].isSelected());
        }if (current == 80) {
            return (radioButton[3].isSelected());
        }if (current == 81) {
            return (radioButton[3].isSelected());
        }if (current == 82) {
            return (radioButton[3].isSelected());
        }if (current == 83) {
            return (radioButton[1].isSelected());
        }if (current == 84) {
            return (radioButton[2].isSelected());
        }if (current == 85) {
            return (radioButton[2].isSelected());
        }if (current == 86) {
            return (radioButton[3].isSelected());
        }if (current == 87) {
            return (radioButton[0].isSelected());
        }if (current == 88) {
            return (radioButton[3].isSelected());
        }if (current == 89) {
            return (radioButton[0].isSelected());
        }if (current == 90) {
            return (radioButton[1].isSelected());
        }if (current == 91) {
            return (radioButton[2].isSelected());
        }if (current == 92) {
            return (radioButton[0].isSelected());
        }if (current == 93) {
            return (radioButton[2].isSelected());
        }if (current == 94) {
            return (radioButton[1].isSelected());
        }if (current == 95) {
            return (radioButton[2].isSelected());
        }if (current == 96) {
            return (radioButton[3].isSelected());
        }if (current == 97) {
            return (radioButton[1].isSelected());
        }if (current == 98) {
            return (radioButton[1].isSelected());
        }if (current == 99) {
            return (radioButton[3].isSelected());
        }if (current == 100) {
            return (radioButton[2].isSelected());
        }if (current == 101) {
            return (radioButton[1].isSelected());
        }if (current == 102) {
            return (radioButton[1].isSelected());
        }if (current == 103) {
            return (radioButton[3].isSelected());
        }if (current == 104) {
            return (radioButton[3].isSelected());
        }if (current == 105) {
            return (radioButton[1].isSelected());
        }if (current == 106) {
            return (radioButton[3].isSelected());
        }if (current == 107) {
            return (radioButton[0].isSelected());
        }if (current == 108) {
            return (radioButton[0].isSelected());
        }if (current == 109) {
            return (radioButton[1].isSelected());
        }if (current == 110) {
            return (radioButton[3].isSelected());
        }if (current == 111) {
            return (radioButton[3].isSelected());
        }if (current == 112) {
            return (radioButton[0].isSelected());
        }if (current == 113) {
            return (radioButton[3].isSelected());
        }if (current == 114) {
            return (radioButton[2].isSelected());
        }if (current == 115) {
            return (radioButton[0].isSelected());
        }if (current == 116) {
            return (radioButton[3].isSelected());
        }if (current == 117) {
            return (radioButton[3].isSelected());
        }if (current == 118) {
            return (radioButton[3].isSelected());
        }if (current == 119) {
            return (radioButton[0].isSelected());
        }if (current == 120) {
            return (radioButton[0].isSelected());
        }if (current == 121) {
            return (radioButton[3].isSelected());
        }if (current == 122) {
            return (radioButton[0].isSelected());
        }if (current == 123) {
            return (radioButton[0].isSelected());
        }
        return false;
    }

    public static void main(String s[]) {
        new programlamadilleri("2017-2020 AYT Matematik Soruları");
    }

}
