package poo.negocios.beans;

public class AvaliacaoOferta {
	int ID_AVALIACAO, ID_MATRICULA, FALTAS;
	float VA1, VA2, VA3, FINAL, MEDIA;
	int SITUACAO;
	public AvaliacaoOferta(){

	}

	public AvaliacaoOferta(int iD_AVALIACAO, int iD_MATRICULA, int fALTAS, int sITUACAO, float vA1, float vA2,
			float vA3, float fINAL, float mEDIA) {
		super();
		ID_AVALIACAO = iD_AVALIACAO;
		ID_MATRICULA = iD_MATRICULA;
		FALTAS = fALTAS;
		SITUACAO = sITUACAO;
		VA1 = vA1;
		VA2 = vA2;
		VA3 = vA3;
		FINAL = fINAL;
		MEDIA = mEDIA;
	}

	public int getID_AVALIACAO() {
		return ID_AVALIACAO;
	}
	public void setID_AVALIACAO(int iD_AVALIACAO) {
		ID_AVALIACAO = iD_AVALIACAO;
	}
	public int getID_MATRICULA() {
		return ID_MATRICULA;
	}
	public void setID_MATRICULA(int iD_MATRICULA) {
		ID_MATRICULA = iD_MATRICULA;
	}
	public int getFALTAS() {
		return FALTAS;
	}
	public void setFALTAS(int fALTAS) {
		FALTAS = fALTAS;
	}
	public int getSITUACAO() {
		return SITUACAO;
	}
	public void setSITUACAO(int sITUACAO) {
		SITUACAO = sITUACAO;
	}
	public float getVA1() {
		return VA1;
	}
	public void setVA1(float vA1) {
		VA1 = vA1;
	}
	public float getVA2() {
		return VA2;
	}
	public void setVA2(float vA2) {
		VA2 = vA2;
	}
	public float getVA3() {
		return VA3;
	}
	public void setVA3(float vA3) {
		VA3 = vA3;
	}
	public float getFINAL() {
		return FINAL;
	}
	public void setFINAL(float fINAL) {
		FINAL = fINAL;
	}
	public float getMEDIA() {
		return MEDIA;
	}
	public void setMEDIA(float mEDIA) {
		MEDIA = mEDIA;
	}




}
