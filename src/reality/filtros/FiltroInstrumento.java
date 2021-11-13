package reality.filtros;

import reality.Banda;

public class FiltroInstrumento extends Filtro {

		private String instrumento;

		public FiltroInstrumento(String instrumento) {
			super();
			this.instrumento = instrumento;
		}

		@Override
		public boolean cumple(Banda b) {
			return b.getInstrumentos().contains(this.instrumento);
		}
		
		
		
}
