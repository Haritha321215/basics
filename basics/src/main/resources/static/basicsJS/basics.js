window.onload= function(){
    document.getElementById("download")
    .addEventListener("click",()=>{
        const page= this.document.getElementById("page");
        let opt={
            margin:1,
            filename: 'addition.pdf',
            image: {type: 'jpeg', quality:8.98},
            html2canvas: { scale:2 },
            jsPDF:{unit: 'in', format: 'letter', orientation:'portrait' }
        };
        html2pdf().from(page).save();
    })
}


