/*
    Copyright Loshun Ltd. 2022
    Updated Thursday, May 19
    Version 0.0
*/

function findChunk()
{
    let x = parseInt(document.getElementById("x").textContent);
    let z = parseInt(document.getElementById("z").textContent);
    
    if (x === NaN || z === NaN) { return; }
    
    let x0 = x / 16 * 16;
    let x1 = x0 + 127;
    let z0 = z / 16 * 16;
    let z1 = z0 + 127;
    
    document.getElementById("result").textConent =
    "Northwest: ( " + x0 + " , " + z0 + " )\nNortheast: ( " + x1 + " , " + z0 +
    " )\nSouthwest: ( " + x0 + " , " + z1 + " )\nSoutheast: ( " + x1 + " , " + z1 + " )";
}
