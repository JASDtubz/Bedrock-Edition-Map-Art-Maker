/*
    Copyright Loshun Ltd. 2022
    Updated Friday, May 20
    Version 0.13
*/

function findChunk()
{
    let x = parseInt(document.getElementById("x").value);
    let z = parseInt(document.getElementById("z").value);
    
    if (isNaN(x) && isNaN(z))
    {
        document.getElementById("nw").textContent = "X value is invalid.";
        document.getElementById("ne").textContent = "Z value is invalid.";
        document.getElementById("sw").textContent = "";
        document.getElementById("se").textContent = "";
        return;
    }
    else if (isNaN(x))
    {
        document.getElementById("nw").textContent = "X value is invalid.";
        document.getElementById("ne").textContent = "";
        document.getElementById("sw").textContent = "";
        document.getElementById("se").textContent = "";
        return;
    }
    else if (isNaN(z))
    {
        document.getElementById("nw").textContent = "Z value is invalid.";
        document.getElementById("ne").textContent = "";
        document.getElementById("sw").textContent = "";
        document.getElementById("se").textContent = "";
        return;
    }
    
    let x0 = Math.floor(x / 128) * 128 - 64;
    let x1 = x0 + 127;
    let z0 = Math.floor(z / 128) * 128 - 64;
    let z1 = z0 + 127;
    
    document.getElementById("nw").textContent = "Northwest: ( " + x0 + " , " + z0 + " )";
    document.getElementById("ne").textContent = "Northeast: ( " + x1 + " , " + z0 + " )";
    document.getElementById("sw").textContent = "Southwest: ( " + x0 + " , " + z1 + " )";
    document.getElementById("se").textContent = "Southeast: ( " + x1 + " , " + z1 + " )";
}
