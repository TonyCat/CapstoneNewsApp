package com.itscatalano.capstonenewsapp

/***
 * Author: Anthony Catalano
 * Data class to hold the source of the Articles
 * This is part of the Articles data class and is represented as a
 * pair in the JSON
 *
 */

data class Source(val id: String? = null, val name: String, val description: String, val url: String, val category:CategoryType , val language:LanguageType , val country: CountryType)



enum class CategoryType{
    business,
    entertainment,
    general,
    health,
    science,
    sports,
    technology,
    all,
}

enum class LanguageType {
    ar,
    de,
    en,
    es,
    fr,
    he,
    it,
    nl,
    no,
    pt,
    ru,
    sv,
    ud,
    zh,
    all,
}

enum class CountryType {
    ae,
    ar,
    at,
    au,
    be,
    bg,
    br,
    ca,
    ch,
    cn,
    co,
    cu,
    cz,
    de,
    eg,
    fr,
    gb,
    gr,
    hk,
    hu,
    id,
    ie,
    il,
    it,
    jp,
    kr,
    lt,
    lv,
    ma,
    mx,
    my,
    ng,
    nl,
    no,
    nz,
    ph,
    pl,
    pt,
    ro,
    rs,
    ru,
    sa,
    se,
    sg,
    si,
    sk,
    th,
    tr,
    tw,
    ua,
    us,
    ve,
    za,
    all,

}