package MurTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import modele.Mur;
import controleur.Global;

class MurTest implements Global {
	Mur mur1 = new Mur();
	Mur mur2 = new Mur();
	@Test
	void testSuperDroite() {
		mur1.setPos(0, 0);
		mur2.setPos(LARGEURMUR/2, 0);
		assertEquals(true, mur1.toucheObjet(mur2));
	}
	
	@Test
	void testPasSuperDroite() {
		mur1.setPos(0, 0);
		mur2.setPos(LARGEURMUR + 1, 0);
		assertEquals(false, mur1.toucheObjet(mur2));
	}
	@Test
	void testSuperGauche() {
		mur1.setPos(0, 0);
		mur2.setPos(LARGEURMUR/2, 0);
		assertEquals(true, mur2.toucheObjet(mur1));
	}
	@Test
	void testPasSuperGauche() {
		mur1.setPos(0, 0);
		mur2.setPos(LARGEURMUR + 1, 0);
		assertEquals(false, mur2.toucheObjet(mur1));
	}
	@Test
	void testSuperHaut() {
		mur1.setPos(0, 0);
		mur2.setPos(0, HAUTEURMUR/2);
		assertEquals(true, mur1.toucheObjet(mur2));
	}
	@Test
	void testPasSuperHaut() {
		mur1.setPos(0, 0);
		mur2.setPos(0, HAUTEURMUR + 1);
		assertEquals(false, mur1.toucheObjet(mur2));
	}
	@Test
	void testSuperBas() {
		mur1.setPos(0, 0);
		mur2.setPos(0, HAUTEURMUR/2);
		assertEquals(true, mur2.toucheObjet(mur1));
	}
	@Test
	void testPasSuperBas() {
		mur1.setPos(0, 0);
		mur2.setPos(0, HAUTEURMUR + 1);
		assertEquals(false, mur2.toucheObjet(mur1));
	}

}
