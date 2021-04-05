package com.example.discussion

class Discussionlist (serialnumber: String?,subname: String?,subtitle: String?, availfrom: String?, availto: String?,duefrom: String?,
    dueto: String?,status: String?){

    private var serialnumber:String
    private var subname:String
    private var subtitle :String
    private var availfrom: String
    private var availto: String
    private var duefrom: String
    private var dueto: String
    private var status:String


    init {
        this.serialnumber=serialnumber!!
        this.subname=subname!!
        this.subtitle=subtitle!!
        this.availfrom= availfrom!!
        this.availto= availto!!
        this.duefrom=duefrom!!
        this.dueto=dueto!!
        this.status=status!!
    }
    fun getSerialnumber():String?{
        return serialnumber
    }
    fun setSerialnumber(serialnumber: String?){
        this.serialnumber=serialnumber!!
    }
    fun getSubname():String?{
        return subname
    }
    fun setSubname(subname: String?){
        this.subname=subname!!
    }

    fun getSubtitle():String?{
        return subtitle
    }
    fun setSubtitle(subtitle: String?){
        this.subtitle=subtitle!!
    }

    fun getAvailfrom():String?{
        return availfrom
    }
    fun setAvailfrom(availfrom: String?){
        this.availfrom=availfrom!!
    }

    fun getAvailto():String?{
        return availto
    }
    fun setAvailto(availto: String?){
        this.availto=availto!!
    }

    fun getDuefrom():String?{
        return duefrom
    }
    fun setDuefrom(duefrom: String?){
        this.duefrom=duefrom!!
    }

    fun getDueto():String?{
        return dueto
    }
    fun setDueto(dueto: String?){
        this.dueto=dueto!!
    }

    fun getStatus():String?{
        return status
    }
    fun setStatus(status: String?){
        this.status=status!!
    }
}

