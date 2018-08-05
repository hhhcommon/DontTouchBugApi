package com.zhengshun.touch.api.common;


public class MsgUtils {


    public static final String CHECK_MSG = "Pengajuan pinjaman telah dikirim";
    public static final String STATE_PRE = "menunggu peninjauan";
    public static final String STATE_AUTO_PASS = "tinjauan otomatis berhasil";
    public static final String STATE_AUTO_REFUSED = "peninjauan tidak lulus";
    public static final String STATE_NEED_REVIEW = "menunggu peninjauan";
    public static final String STATE_PASS = "tinjauan ulang oleh operator berhasil";
    public static final String STATE_REFUSED = "peninjauan tidak lulus";//tinjauan ulang oleh operator gagal
    public static final String STATE_REPAY = "Dana pinjaman berhasil dikirim";
    public static final String STATE_REPAY_FAIL = "peminjaman gagal";
    public static final String STATE_FINISH = "Pelunasan Berhasil";
    public static final String STATE_REMISSION_FINISH = "pelunasan berhasil - pemotongan utang";
    public static final String STATE_REPAY_PROCESSING = "pelunasan sedang diproses";
    public static final String PENALTY_MSG = "Jatuh Tempo";
    public static final String STATE_BAD = "sudah menjadi piutang tak tertagih";
    public static final String WAIT_AUDIT_LOAN = "menanti peninjauan pinjaman";
    public static final String AUDIT_LOAN_PASS = "tinjauan pinjaman berhasil";
    public static final String AUDIT_LOAN_FAIL = "tinjauan pinjaman gagal";
    public static final String STATE_PASS_APP = "tinjauan berhasil";
    public static final String STATE_REFUSED_APP = "peninjauan tidak lulus"; //tinjauan gagal
    public static final String STATE_FINISH_APP = "Pelunasan Berhasil";
    public static final String STATE_PRE_APP = "sedang dalam peninjauan, harap tunggu";
    public static final String STATE_AUTO_PASS_APP = "Selamat! Pengajuan pinjaman anda telah disetujui, dana pinjaman akan dikirim ke no rekening bank terikat";
    public static final String STATE_AUTO_REFUSED_APP = "Maaf, Pengajuan pinjaman anda tidak disetujui";
    public static final String STATE_NEED_REVIEW_APP = "sedang dalam proses peninjauan, tolong tunggu sebentar";
    public static final String STATE_PASS_APP_MSG = "selamat! tinjauan manajemen risiko berhasil";
    public static final String STATE_REFUSED_MSG = "mohon maaf, tinjauan manajemen risiko gagal";
    public static final String STATE_REPAY_APP = "Dana pinjaman sudah terkirim, silahkan periksa rekening bank anda,proses penerimaan dana butuh beberapa waktu, mohon tunggu sebentar";
    public static final String MAKING_ERROR_MSG = "peminjaman gagal";
    public static final String STATE_REMISSION_FINISH_APP = "peminjam tidak mampu melunasi seluruh utang, pemotongan nominal utang disetujui";
    public static final String STATE_REPAY_PROCESSING_APP = "pelunasan sedang diproses";
    public static final String STATE_DELAY_APP = "Pinjaman anda telah jatuh tempo,untuk mencegah pemotongan poin anda, silahkan langsung melakukan pelunasan secepatnya.";
    public static final String STATE_BAD_APP = "sudah dilakukan penagihan dalam jangka waktu lama, tidak ada hasil";
    public static final String WAIT_AUDIT_LOAN_APP = "menanti tinjauan pinjaman";
    public static final String AUDIT_LOAN_PASS_APP = "tinjauan pinjaman berhasil lulus";
    public static final String AUDIT_LOAN_FAIL_APP = "mohon maaf, tidak lulus tinjauan pinjaman";
    public static final String STATE_REPAY_PART_APP = "Cicilan sudah terbayar Rp%s, silahkan melunasi sisa pinjaman dalam waktu yang telah ditentukan";
    public static final String STATE_REPAY_OVER_APP_MSG = "pelunasan melebihi nominal tagihan, silahkan hubungi operator";
    public static final String STATE_REPAY_OVER_BACKED = "Pelunasan Berlebih";
    public static final String STATE_REPAY_OVER_APP = "Pelunasan Berlebih";
    public static final String OPERATE_SUCCESS_MSG = "操作成功";
    public static final String OPERATE_FAIL_MSG = "操作失败";
    public static final String AUTO_AUDIT_LOAN_REJECT = "Selamat! anda sudah lolos tahap pertama peninjauan kami, pengajuan pinjaman anda sedang diproses, mohon sabar menunggu";
    public static final String AUTO_AUDIT_LOAN_REJECT_TITLE = "Status terbaru peninjauan pinjaman";

    public static final String IDNO_FAIL = "身份证已被使用";
    public static final String IDNO_AUTH_COUNT = "身份认证已达系统限制次数，请明日再来";
    public static final String BANK_BIND_FAIL = "绑卡失败";
    public static final String NAME_CHECK = "请先完成实名认证";
    public static final String SMSCODE_SUCCESS_MSG = "已发送，请注意查收";
    public static final String SMSCODE_FAIL_MSG = "发送失败";
    public static final String PHONE_EXITS_MSG = "该手机号码已被注册";
    public static final String PHONE_NOTEXITS_MSG = "该手机不存在，可注册";
}
