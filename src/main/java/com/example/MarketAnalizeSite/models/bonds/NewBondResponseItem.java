package com.example.MarketAnalizeSite.models.bonds;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewBondResponseItem implements Comparable {

    //    @JsonProperty("q_ratingroe")
    private String qRatingroe;

    //    @JsonProperty("q_earningsdp2")
    private Object qEarningsdp2;

    //    @JsonProperty("q_fear")
    private String qFear;

    //    @JsonProperty("expert")
    private Object expert;

    //    @JsonProperty("is_qualify")
    private String isQualify;

    //    @JsonProperty("q_valueroe")
    private Object qValueroe;

    //    @JsonProperty("q_valueros")
    private Object qValueros;

    //    @JsonProperty("matdate")
    private String matdate;

    @JsonProperty("couponpercent")
    private String couponpercent;

    @JsonProperty("total_return")
    private String totalReturn;

    @JsonProperty("isiis")
    private String isiis;

    @JsonProperty("price")
    private String price;

    @JsonProperty("mod_duration")
    private String modDuration;

    //    @JsonProperty("effective_date")
    private String effectiveDate;

    @JsonProperty("id")
    private String id;

    //    @JsonProperty("q_earnings")
    private String qEarnings;

    //    @JsonProperty("listlevel")
    private String listlevel;

    //    @JsonProperty("last_cup")
    private String lastCup;

    //    @JsonProperty("q_balanceliq")
    private Object qBalanceliq;

    //    @JsonProperty("bond_link")
    private String bondLink;

    //    @JsonProperty("q_indp1")
    private Object qIndp1;

    //    @JsonProperty("q_valuequiqliq")
    private Object qValuequiqliq;

    //    @JsonProperty("qualinvestorgroup")
    private String qualinvestorgroup;

    //    @JsonProperty("q_inventorturnov")
    private Object qInventorturnov;

    @JsonProperty("shortname")
    private String shortname;

    //    @JsonProperty("future_cost")
    private String futureCost;

    //    @JsonProperty("quality")
    private String quality;

    //    @JsonProperty("q_stability")
    private Object qStability;

    //    @JsonProperty("secname")
    private String secname;

    //    @JsonProperty("q_dp1")
    private Object qDp1;

    @JsonProperty("size")
    private String size;

    @JsonProperty("current_yield")
    private String currentYield;

    @JsonProperty("calc_current_yield")
    private String calcCurrentYield;

    //    @JsonProperty("tax_currency_free")
    private String taxCurrencyFree;

    @JsonProperty("calc_isin")
    private String calcIsin;

    //    @JsonProperty("borrower_country")
    private String borrowerCountry;

    //    @JsonProperty("boardname")
    private String boardname;

    //    @JsonProperty("q_outdp1")
    private Object qOutdp1;

    //    @JsonProperty("complexity")
    private String complexity;

    //    @JsonProperty("best_score")
    private String bestScore;

    @JsonProperty("couponvalue")
    private String couponvalue;

    //    @JsonProperty("minlot")
    private String minlot;

    //    @JsonProperty("strategy3")
    private String strategy3;

    @JsonProperty("minlottype")
    private String minlottype;

    //    @JsonProperty("strategy4")
    private String strategy4;

    //    @JsonProperty("vol_median")
    private String volMedian;

    @JsonProperty("nkd")
    private String nkd;

    //    @JsonProperty("strategy5")
    private String strategy5;

    //    @JsonProperty("strategy6")
    private String strategy6;

    //    @JsonProperty("issuesize")
    private String issuesize;

    //    @JsonProperty("update_time")
    private String updateTime;

    //    @JsonProperty("ourselect")
    private String ourselect;

    //    @JsonProperty("issue_date")
    private String issueDate;

    @JsonProperty("nominal")
    private String nominal;

    //    @JsonProperty("moody")
    private Object moody;

    @JsonProperty("yield")
    private String yield;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("simple_yield")
    private String simpleYield;

    @JsonProperty("event")
    private String event;

    @JsonProperty("price_return")
    private String priceReturn;

    //    @JsonProperty("sp")
    private Object sp;

    @JsonProperty("next_coupon_date")
    private String nextCouponDate;

    //    @JsonProperty("reinvesting")
    private String reinvesting;

    @JsonProperty("emitent_type")
    private String emitentType;

    @JsonProperty("coupon")
    private String coupon;

    @JsonProperty("sector_text")
    private String sectorText;

    @JsonProperty("company_id")
    private Object companyId;

    @JsonProperty("change")
    private String change;

    //    @JsonProperty("borrower")
    private String borrower;

    //    @JsonProperty("q_currentliq")
    private Object qCurrentliq;

    //    @JsonProperty("q_receivableturnov")
    private Object qReceivableturnov;

    //    @JsonProperty("q_ros")
    private Object qRos;

    //    @JsonProperty("hide")
    private String hide;

    @JsonProperty("fact_yield")
    private String factYield;

    //    @JsonProperty("q_turnovofcurasset")
    private Object qTurnovofcurasset;

    //    @JsonProperty("guarantor_type")
    private String guarantorType;

    //    @JsonProperty("q_ratingnetdebt_equity")
    private String qRatingnetdebtEquity;

    //    @JsonProperty("strategy1")
    private String strategy1;

    @JsonProperty("reinvesting_part")
    private String reinvestingPart;

    @JsonProperty("strategy2")
    private String strategy2;

    @JsonProperty("buybackdate")
    private String buybackdate;

    @JsonProperty("seniority")
    private Object seniority;

    //    @JsonProperty("tax_longterm_free")
    private String taxLongtermFree;

    //    @JsonProperty("q_balance")
    private String qBalance;

    //    @JsonProperty("q_valueturnovofcurasset")
    private Object qValueturnovofcurasset;

    //    @JsonProperty("q_in")
    private String qIn;

    @JsonProperty("coupondate")
    private String coupondate;

    @JsonProperty("liquidity")
    private String liquidity;

    //    @JsonProperty("q_valuenetdebt_equity")
    private Object qValuenetdebtEquity;

    //    @JsonProperty("facevalue")
    private String facevalue;

    //    @JsonProperty("q_valueshortliabilities")
    private Object qValueshortliabilities;

    //    @JsonProperty("boardid")
    private String boardid;

    //    @JsonProperty("is_roe")
    private String isRoe;

    //    @JsonProperty("isqualinvestors")
    private String isqualinvestors;

    //    @JsonProperty("last")
    private String last;

    //    @JsonProperty("value_of_emission")
    private String valueOfEmission;

    @JsonProperty("yieldtoprevyield")
    private String yieldtoprevyield;

    @JsonProperty("accruedint")
    private String accruedint;

    //    @JsonProperty("instrid")
    private String instrid;

    //    @JsonProperty("liquidity_xml")
    private String liquidityXml;

    @JsonProperty("secid")
    private String secid;

    @JsonProperty("current_coupon_prc")
    private String currentCouponPrc;

    //    @JsonProperty("q_operprof")
    private Object qOperprof;

    @JsonProperty("couponperiod")
    private String couponperiod;

    //    @JsonProperty("q_valuecashratio")
    private Object qValuecashratio;

    @JsonProperty("name")
    private String name;

    //    @JsonProperty("xml_isin")
    private String xmlIsin;

    @JsonProperty("eqiv_simple_yield")
    private String eqivSimpleYield;

    @JsonProperty("coupon_type")
    private String couponType;

    //    @JsonProperty("q_valuecol")
    private Object qValuecol;

    //    @JsonProperty("q_balancedp3")
    private Object qBalancedp3;

    //    @JsonProperty("q_valuereceivableturnov")
    private Object qValuereceivableturnov;

    //    @JsonProperty("rutrade")
    private String rutrade;

    //    @JsonProperty("down_risk")
    private String downRisk;

    @JsonProperty("description")
    private String description;

    @JsonProperty("maturity_date")
    private String maturityDate;

    //    @JsonProperty("instrument_type")
    private String instrumentType;

    //    @JsonProperty("q_valuecurrentliq")
    private Object qValuecurrentliq;

    //    @JsonProperty("bond_std")
    private String bondStd;

    @JsonProperty("duration")
    private String duration;

    //    @JsonProperty("q_valueoperprof")
    private Object qValueoperprof;

    //    @JsonProperty("commentmd")
    private String commentmd;

    //    @JsonProperty("q_col")
    private String qCol;

    @JsonProperty("coupon_period")
    private String couponPeriod;

    //    @JsonProperty("q_ratingcashratio")
    private Object qRatingcashratio;

    //    @JsonProperty("q_out")
    private String qOut;

    @JsonProperty("emitent")
    private String emitent;

    //    @JsonProperty("not_reinvesting")
    private String notReinvesting;

    @JsonProperty("bond_type")
    private String bondType;

    //    @JsonProperty("is_show")
    private String isShow;

    //    @JsonProperty("spread")
    private String spread;

    //    @JsonProperty("q_shortliabilities")
    private Object qShortliabilities;

    @JsonProperty("credit_rating")
    private String creditRating;

    //    @JsonProperty("q_quiqliq")
    private Object qQuiqliq;

    @JsonProperty("years_to_maturity")
    private String yearsToMaturity;

    @JsonProperty("akra")
    private Object akra;

    //    @JsonProperty("tax_free")
    private String taxFree;

    @JsonProperty("credit_rating_text")
    private String creditRatingText;

    //    @JsonProperty("fitch")
    private Object fitch;

    //    @JsonProperty("comment")
    private Object comment;

    //    @JsonProperty("category")
    private String category;

    @JsonProperty("currencyid")
    private String currencyid;

    @JsonProperty("isin")
    private String isin;

    //    @JsonProperty("q_valueinventorturnov")
    private Object qValueinventorturnov;

    //    @JsonProperty("eventFlag")
    private String eventFlag;

    @Override
    public int compareTo(@NotNull Object o) {
        return 0;
    }
}
