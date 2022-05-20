/*
    Copyright Loshun Ltd. 2022
    Updated Thursday, May 19
    Version 0.6
*/

function findChunk()
{
    let x = parseInt(document.getElementById("x").value);
    let z = parseInt(document.getElementById("z").value);
    
    if (isNaN(x) || isNaN(z)) { return; }
    
    let x0 = (x / 16) * 16;
    let x1 = x0 + 127;
    let z0 = (z / 16) * 16;
    let z1 = z0 + 127;
    
    document.getElementById("result").textContent = "Northwest: ( " + x0 + " , " + z0 + " )<br/>Northeast: ( " + x1 + " , " + z0 + " )<br/>Southwest: ( " + x0 + " , " + z1 + " )<br/>Southeast: ( " + x1 + " , " + z1 + " )";
}
