//function Alg(){
//    var self = this;
    
function getSigma(){
    var p = $('#p').val().trim() * 1.0;
    var Dn = $('#Dn').val().trim() * 1.0;
    var delta = $('#delta').val().trim() * 1.0;
    //        var alfa = $('#alfa').val().trim() * 1.0;
    var alfa = 12 / 1000000.0;
    var t = $('#t').val().trim() * 1.0;
    //        var mu = $('#mu').val().trim() * 1.0;
    var mu = 0.28;
    //        var E = $('#E').val().trim() * 1.0;
    var E = 210;
        
        
    console.log(p);
    console.log(Dn);
    console.log(delta);
    console.log(alfa);
    console.log(t);
    console.log(mu);
        
    var sigmaKc = p*(Dn - 2*delta)/(2 * delta);
    console.log('sigmaKc = ' + sigmaKc);
    var sigmaPr = -alfa*E*1000*(20 - t) + mu*sigmaKc;
    console.log('sigmaPr = ' + sigmaPr);
    var sigma = Math.sqrt(sigmaKc*sigmaKc - sigmaKc*sigmaPr + sigmaPr*sigmaPr);
    console.log('sigma = ' + sigma);
        
//    $('#sigmaBlock').html('<br/> &sigma; = ' + sigma);
//    $('#sigmaBlock').show();
        
    return sigma;
}
    
function getT(){
    var Tpr = $('#Tpr').val().trim() * 1.0;
    var M = $('#M').val().trim() * 1.0;
    var Cp = $('#Cp').val().trim() * 1.0;
    var Tgr = $('#Tgr').val().trim() * 1.0;
    var x = $('#x').val().trim() * 1.0;
    var K = $('#K').val().trim() * 1.0;
    var Dn = $('#Dn').val().trim() / 1000.0;
        
    var x0 = (M*Cp)/(Math.PI * Dn * K);
    var T = Tgr + (Tpr - Tgr) * Math.exp(-x0/x);
    console.log('T = ' + T);
    return T;
}
    
function getCdop(){
    var delta = $('#delta').val() * 1.0;
    var p = $('#p').val().trim() * 1.0;
    var Dn = $('#Dn').val().trim() * 1.0;
        
    var Cdop = delta - p*Dn/(2*(320 + p));
    return Cdop;
}
    
function getTost(vCorr){
    console.log('getTost occured');
    console.log(vCorr);
    var Cfak = $('#Cfak').val().trim() * 1.0;
    var Cdop = getCdop();
    var result = (Cdop - Cfak) / vCorr;
    console.log('result = ' + result);
    return result;
}
    
    
//}
