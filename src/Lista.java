public class Lista {
    private No inicio,fim;

    public No getInicio() {
        return inicio;
    }

    public void setInicio(No inicio) {
        this.inicio = inicio;
    }

    public No getFim() {
        return fim;
    }

    public void setFim(No fim) {
        this.fim = fim;
    }

    public Lista(No inicio, No fim) {
        this.inicio = inicio;
        this.fim = fim;
    }

    public Lista() {
        this.inicio = null;
        this.fim = null;
    }

    public No getStart() {
        return inicio;
    }

    public void insertList(int value){
        No novo = new No(value,null,null);
        if(inicio==null){
            inicio = fim = novo;
        }
        else{
            novo.setAnt(fim);
            fim.setProx(novo);
            fim = novo;
        }
    }

    public No getIndex(int n){
        int i=0;
        No aux = inicio;
        while(i!=n && aux!=null){
            i++;
            aux = aux.getProx();
        }
        return aux;
    }

    public void showList(){
        No aux = inicio;
        while(aux != null){
            System.out.print(aux.getValue() + " ");
            aux = aux.getProx();
        }
        System.out.println();
    }

    public void insertionSort(){
        No aux = inicio,aux2,aux3;
        int value;
        aux = aux.getProx();
        while (aux != null){
            aux2 = aux;
            value = aux.getValue();
            while(aux2 != inicio && aux2.getAnt().getValue() > value){
                aux2.setValue(aux2.getAnt().getValue());
                aux2 = aux2.getAnt();
            }
            aux2.setValue(value);
            aux = aux.getProx();
        }
    }

    public No getMeio(No no, int TL){
        for(int i = 0; i < TL; i++)
            no = no.getProx();

        return no;
    }

    public No buscaBinariaInsercaoBinaria(int info, int TL){
        int ini = 0, fim = TL-1, meio = fim / 2;
        No aux = inicio;
        No m = getIndex(meio);
        while(ini < fim && m.getValue() != info){
            if(info > m.getValue()){
                ini = meio + 1;
                aux = m.getProx();
            }
            else
                fim = meio - 1;
            meio = (ini+fim)/2;
            m = getMeio(aux, meio-ini);
        }
        if(info > m.getValue())
            return m.getProx();
        return m;
    }
    public void insercaoBinaria(){
        int value, TL = 1;
        No pos, aux = inicio.getProx(), aux2;
        while(aux  != null){
            value = aux .getValue();
            pos = buscaBinariaInsercaoBinaria(value, TL++);
            aux2 = aux;
            while(aux2!=pos && aux2.getAnt()!=null){
                aux2.setValue(aux2.getAnt().getValue());
                aux2 = aux2.getAnt();
            }
            pos.setValue(value);
            aux  = aux .getProx();
        }
    }

    public void selectionSort() {
        No aux = inicio;
        while (aux != null) {
            No minNo = aux;
            No temp = aux.getProx();
            while (temp != null) {
                if (temp.getValue() < minNo.getValue()) {
                    minNo = temp;
                }
                temp = temp.getProx();
            }
            if(minNo != aux){
                int valor = aux.getValue();
                aux.setValue(minNo.getValue());
                minNo.setValue(valor);
            }
            aux = aux.getProx();
        }
    }

    public void bubbleSort(){
        No aux = inicio,aux2;
        int valor;
        while(aux != null){
            aux2 = inicio;
            while(aux2.getProx() != null){
                if(aux2.getValue() > aux2.getProx().getValue()){
                    valor = aux2.getValue();
                    aux2.setValue(aux2.getProx().getValue());
                    aux2.getProx().setValue(valor);
                }
                aux2 = aux2.getProx();
            }
            aux = aux.getProx();
        }
    }

    public void coutingSort(){
        int maxValue = inicio.getValue();
        No aux = inicio.getProx();
        while(aux != null){
            if(maxValue < aux.getValue()){
                maxValue = aux.getValue();
            }
            aux = aux.getProx();
        }
        int cont[] = new int[maxValue+1];
        aux = inicio;
        while(aux != null){
            cont[aux.getValue()]++;
            aux = aux.getProx();
        }
        aux = inicio;
        for(int a = 0;a <= maxValue;a++){
            while(cont[a] != 0){
                aux.setValue(a);
                aux = aux.getProx();
                cont[a]--;
            }
        }
    }

    public void shakeSort(){
        boolean swapped;
        No bottom = inicio,top = fim,aux,aux2;
        int value;
        do{
            swapped = false;
            aux = bottom;
            while(aux != top){
                if(aux.getValue() > aux.getProx().getValue()){
                    value = aux.getValue();
                    aux.setValue(aux.getProx().getValue());
                    aux.getProx().setValue(value);
                    swapped = true;
                }
                aux = aux.getProx();
            }
            top = top.getAnt();
            if(swapped){
                swapped = false;
                aux = top;
                while(aux != bottom){
                    if(aux.getValue() < aux.getAnt().getValue()){
                        value = aux.getValue();
                        aux.setValue(aux.getAnt().getValue());
                        aux.getAnt().setValue(value);
                        swapped = true;
                    }
                    aux = aux.getAnt();
                }
                bottom = bottom.getProx();
            }
        }while(swapped);
    }

    public void gnomeSort(){
        No aux = inicio;
        int value;
        while(aux != null){
            if(aux==inicio || aux.getAnt().getValue()<= aux.getValue()){
                aux = aux.getProx();
            }
            else{
                value = aux.getAnt().getValue();
                aux.getAnt().setValue(aux.getValue());
                aux.setValue(value);
                aux = aux.getAnt();
            }
        }
    }

    public void bucketSort(int n){
        int maxValue = inicio.getValue();
        No aux = inicio.getProx(),aux2;
        while(aux != null){
            if(maxValue < aux.getValue()){
                maxValue = aux.getValue();
            }
            aux = aux.getProx();
        }
        Lista balde[] = new Lista[n];
        for (int i = 0; i < n; i++) {
            balde[i] = new Lista();
        }
        aux = inicio;
        while(aux != null){
            int pos = (int) ((aux.getValue()*1.0)/maxValue)*(n-1);
            balde[pos].insertList(aux.getValue());
            aux = aux.getProx();
        }
        for(int a=0;a < n; a++){
            balde[a].bubbleSort();
        }
        aux = inicio;
        for(int a=0;a < n; a++){
            aux2 = balde[a].getStart();
            while(aux2!=null){
                aux.setValue(aux2.getValue());
                aux = aux.getProx();
                aux2 = aux2.getProx();
            }
        }
    }

    public void combSort(){
        int gap = 0,tl;
        boolean trocas = true;
        Lista ajd = new Lista();
        No aux = inicio,aux2;
        while(aux != null){
            gap++;
            aux = aux.getProx();
        }
        tl = gap;
        while (gap > 1 || trocas) {
            if (gap > 1){
                gap = (int) (gap / 1.3);
            }
            int i = 0;
            trocas = false;
            aux = getIndex(0);
            aux2 = getIndex(gap);
            while (i + gap < tl) {
                if(aux.getValue() > aux2.getValue()){
                    int swap = aux.getValue();
                    aux.setValue(aux2.getValue());
                    aux2.setValue(swap);
                    trocas = true;
                }
                aux = aux.getProx();
                aux2 = aux2.getProx();
                i++;
            }
        }
    }

    private void fusao(Lista list1, Lista list2, int seq,int TL) {
        int i=0, j=0, k=0, tam=seq;
        No aux = inicio, aux1 = list1.getStart(), aux2 = list2.getStart() ;
        while(k < TL) {
            while (i < seq && j < seq) {
                if (aux1.getValue() < aux2.getValue()) {
                    aux.setValue(aux1.getValue());
                    aux = aux.getProx();
                    aux1 = aux1.getProx();
                    k++; i++;
                } else {
                    aux.setValue(aux2.getValue());
                    aux = aux.getProx();
                    aux2 = aux2.getProx();
                    k++; j++;
                }
            }

            while (i < seq) {
                aux.setValue(aux1.getValue());
                aux = aux.getProx();
                aux1 = aux1.getProx();
                k++; i++;
            }
            while (j < seq) {
                aux.setValue(aux2.getValue());
                aux = aux.getProx();
                aux2 = aux2.getProx();
                k++; j++;
            }
            seq = seq + tam;
        }
    }

    private Lista particao(int i, int TL) {
        Lista lista = new Lista();
        No aux=getIndex(i);
        while(TL>0){
            lista.insertList(aux.getValue());
            TL--;
            aux = aux.getProx();
        }
        return lista;
    }
    public void mergeSort1(){
        Lista list1,list2;
        No aux=inicio;
        int seq=1,TL=0;
        while(aux!=null){
            TL++;
            aux = aux.getProx();
        }
        while(seq < TL){
            list1 = particao(0,TL/2);
            list2 = particao(TL/2,TL/2);
            fusao(list1, list2, seq,TL);
            seq = seq*2;
        }
    }

    public int particaoQuickPivo(int esq,int dir){
        int x = getIndex((esq+dir)/2).getValue();
        int i = esq,j = dir,valor;
        No aux = getIndex(i), aux2 = getIndex(j);
        do{
            while(x > aux.getValue()){
                i++;
                aux = aux.getProx();
            }
            while(x < aux2.getValue()){
                j--;
                aux2 = aux2.getAnt();
            }
            if(i<=j){
                valor = aux.getValue();
                aux.setValue(aux2.getValue());
                aux2.setValue(valor);
                i++;
                j--;
                aux = aux.getProx();
                aux2 = aux2.getAnt();
            }
        }while(i<=j);
        return i;
    }

    public void ordenaPivo(int esq,int dir){
        if(esq<dir){
            int m = particaoQuickPivo(esq, dir);
            ordenaPivo(esq,m-1);
            ordenaPivo(m,dir);
        }
    }

    public void quickSortPivo(){
        int TL=0;
        No aux = inicio;
        while(aux!=null){
            TL++;
            aux = aux.getProx();
        }
        ordenaPivo(0,TL-1);
    }

    public void heapSort(){
        int pai, TL=0, E, D, aux;
        No aux2;
        No Pai, noTL2 = fim, noE, noD, noMaiorF;
        aux2 = inicio;
        while(aux2 != null){
            TL++;
            aux2 = aux2.getProx();
        }
        while(TL > 0){
            pai = (TL/2)-1;
            Pai = getIndex(pai);
            while(pai >= 0){
                E = (pai*2) + 1;
                D = E + 1;
                noE = getIndex(E);
                noD = getIndex(D);
                noMaiorF = noE;
                if(D < TL && noD.getValue() > noE.getValue())
                    noMaiorF = noD;
                if(Pai.getValue() < noMaiorF.getValue()) {
                    aux = Pai.getValue();
                    Pai.setValue(noMaiorF.getValue());
                    noMaiorF.setValue(aux);
                }
                pai--;
                Pai = Pai.getAnt();
            }
            TL--;
            aux = noTL2.getValue();
            noTL2.setValue(inicio.getValue());
            inicio.setValue(aux);
            noTL2 = noTL2.getAnt();
        }
    }

    public void countingSortForRadix(int d) {
        int TL = 0;
        No aux = inicio;
        while (aux != null) {
            TL++;
            aux = aux.getProx();
        }
        int[] cont = new int[10];
        int[] output = new int[TL];

        for (int i = 0; i < 10; i++) {
            cont[i] = 0;
        }

        for (aux = inicio; aux != null; aux = aux.getProx()) {
            cont[(aux.getValue() / d) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            cont[i] += cont[i - 1];
        }

        aux = fim;
        while (aux != null) {
            output[cont[(aux.getValue() / d) % 10] - 1] = aux.getValue();
            cont[(aux.getValue() / d) % 10]--;
            aux = aux.getAnt();
        }

        aux = inicio;
        for (int i = 0; i < TL; i++) {
            aux.setValue(output[i]);
            aux = aux.getProx();
        }
    }

    public void radixSort() {
        int maxValue = inicio.getValue();
        No aux = inicio.getProx();
        while (aux != null) {
            if (maxValue < aux.getValue()) {
                maxValue = aux.getValue();
            }
            aux = aux.getProx();
        }

        for (int i = 1; maxValue / i > 0; i *= 10) {
            countingSortForRadix(i);
        }
    }

    private int particaoQuick(int ini, int fim){
        int i = ini, j = fim;
        int valor;

        No aux1 = getIndex(ini), aux2 = getIndex(fim);

        while(i < j){
            while(i < j && aux1.getValue() <= aux2.getValue()){
                i++;
                aux1 = aux1.getProx();
            }
            valor = aux2.getValue();
            aux2.setValue(aux1.getValue());
            aux1.setValue(valor);
            while(j > i && aux2.getValue() >= aux1.getValue()){
                j--;
                aux2 = aux2.getAnt();
            }

            valor = aux2.getValue();
            aux2.setValue(aux1.getValue());
            aux1.setValue(valor);
        }
        return i;
    }


    public void ordena(int esq,int dir){
        if(esq<=dir){
            int m = particaoQuick(esq, dir);
            ordena(esq,m-1);
            ordena(m+1,dir);
        }
    }
    public void quickSort(){
        int TL = 0;
        No aux = inicio;
        while(aux!=null){
            TL++;
            aux = aux.getProx();
        }
        ordena(0, TL-1);
    }

    public void fusao2(int ini1, int fim1, int ini2, int fim2, Lista lista){
        int i = ini1, j = ini2, k = 0;
        No aux = getIndex(i),aux2 = getIndex(j), aux3 = lista.getInicio();
        while(i<=fim1 && j<=fim2){

            if(aux.getValue() < aux2.getValue()){
                aux3.setValue(aux.getValue());
                aux = aux.getProx();
                aux3 = aux3.getProx();
                k++; i++;
            }
            else{
                aux3.setValue(aux2.getValue());
                aux2 = aux2.getProx();
                aux3 = aux3.getProx();
                k++; j++;
            }
        }

        while(i<=fim1){
            aux3.setValue(aux.getValue());
            aux = aux.getProx();
            aux3 = aux3.getProx();
            k++; i++;
        }
        while(j<=fim2){
            aux3.setValue(aux2.getValue());
            aux2 = aux2.getProx();
            aux3 = aux3.getProx();
            k++; j++;
        }
        i=0;
        aux = getIndex(ini1);
        aux3 = lista.getInicio();
        while (i < k){
            aux.setValue(aux3.getValue());
            aux = aux.getProx();
            aux3 = aux3.getProx();
            i++;
        }

    }

    public void merge2(int esq, int dir, Lista lista){
        if(esq<dir){
            int meio = (esq+dir)/2;
            merge2(esq, meio, lista);
            merge2(meio+1, dir, lista);
            fusao2(esq, meio, meio+1, dir, lista);
        }
    }

    public void mergeSort2(){
        Lista lista = new Lista();
        int TL = 0;
        No aux = inicio;
        while(aux != null){
            TL++;
            aux = aux.getProx();
        }
        for(int i=0;i<TL;i++){
            lista.insertList(i);
        }
        merge2(0,TL-1,lista);
    }

    public void insercaoDiretaTim(No ini, No fim) {
        No aux = ini.getProx();
        while (aux != fim.getProx()) {
            No aux2 = aux;
            int value = aux.getValue();
            while (aux2 != ini && aux2.getAnt().getValue() > value) {
                aux2.setValue(aux2.getAnt().getValue());
                aux2 = aux2.getAnt();
            }
            aux2.setValue(value);
            aux = aux.getProx();
        }
    }

    public void mergeTim(int ini, int fim1, int ini2, int fim2) {
        int i = ini, j = ini2;
        Lista lista = new Lista();
        No aux = getIndex(ini), aux2 = getIndex(ini2);

        while (i <= fim1 && j <= fim2) {
            if (aux.getValue() < aux2.getValue()) {
                lista.insertList(aux.getValue());
                aux = aux.getProx();
                i++;
            } else {
                lista.insertList(aux2.getValue());
                aux2 = aux2.getProx();
                j++;
            }
        }

        while (i <= fim1) {
            lista.insertList(aux.getValue());
            aux = aux.getProx();
            i++;
        }

        while (j <= fim2) {
            lista.insertList(aux2.getValue());
            aux2 = aux2.getProx();
            j++;
        }

        No aux3 = lista.getInicio();
        aux = getIndex(ini);
        while (aux3 != null) {
            aux.setValue(aux3.getValue());
            aux = aux.getProx();
            aux3 = aux3.getProx();
        }
    }

    public void timSort(){
        int divisor = 32, TL = 0;
        No aux = inicio;
        while ( aux !=null){
            TL++;
            aux = aux.getProx();
        }

        for(int i = 0; i<TL; i+=divisor)
            insercaoDiretaTim(getIndex( i), getIndex( Math.min(i+divisor-1, (TL-1))));

        showList();

        for(int n = divisor; n < TL; n = 2*n){
            for(int ini = 0; ini < TL; ini += 2*n){
                int meio = ini + n - 1;
                int fim = Math.min(ini + 2 * n - 1, TL-1);
                if(meio < fim)
                    mergeTim(ini, meio,meio+1, fim);
            }
        }
    }

    public void shellSort(){
        int h = 1, TL = 0;
        No aux = inicio;
        while ( aux !=null){
            TL++;
            aux = aux.getProx();
        }
        while(h * 3 + 1 < TL) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            for (int i = h; i < TL; i++) {
                int valor = getIndex(i).getValue();
                int j = i;
                while (j >= h && getIndex(j-h).getValue() > valor) {
                    getIndex(j).setValue(getIndex(j-h).getValue());
                    j = j - h;
                }
                getIndex(j).setValue(valor);
            }
            h = (h-1)/3;
        }
    }

}
