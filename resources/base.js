/**
 * Created by Bernd on 29.08.2015.
 */

if(print && !console){
    var console = {
        log : print,
        error : print,
        info : print
    };
}
