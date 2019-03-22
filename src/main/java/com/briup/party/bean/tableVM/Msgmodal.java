package com.briup.party.bean.tableVM;

import com.briup.party.bean.table.Userdtl;
import com.briup.party.bean.table.Useretd;

/**
 * 封装用于返回用户详细数据的pojo类
 */
public class Msgmodal {

    private Userdtl userdtl;

    private Useretd useretd;

    public Userdtl getUserdtl() {
        return userdtl;
    }

    public void setUserdtl(Userdtl userdtl) {
        this.userdtl = userdtl;
    }

    public Useretd getUseretd() {
        return useretd;
    }

    public void setUseretd(Useretd useretd) {
        this.useretd = useretd;
    }


}
