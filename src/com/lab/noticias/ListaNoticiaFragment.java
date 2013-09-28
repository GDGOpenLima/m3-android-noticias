package com.lab.noticias;

import java.util.ArrayList;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListaNoticiaFragment extends ListFragment {

	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreateView(inflater, container, savedInstanceState);
		
		View vista = inflater.inflate(R.layout.listanoticia_fragment, 
							container, false);
		
		return vista;
	}

	
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		NoticiaTO noticiaTO1 = new NoticiaTO();
		noticiaTO1.titulo="<H1>a</H1>";
		noticiaTO1.notaCorta="a";
		
		NoticiaTO noticiaTO2 = new NoticiaTO();
		noticiaTO2.titulo="<H1>a</H1>";
		noticiaTO2.notaCorta="a";
		
		ArrayList<NoticiaTO> noticias = new ArrayList<NoticiaTO>();
		noticias.add(noticiaTO1);
		noticias.add(noticiaTO2);
		
		Adaptador adaptador = new Adaptador(this.getActivity(), noticias);
		setListAdapter(adaptador);
	}



	private class Adaptador extends ArrayAdapter<NoticiaTO>
	{

		private Context context;
		private ArrayList<NoticiaTO> detalle;
		
		public Adaptador(Context context,ArrayList<NoticiaTO> detalle) {
			super(context,R.layout.listanoticia_content, detalle);
			// TODO Auto-generated constructor stub
			this.context = context;
			this.detalle = detalle;

		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			
			
			NoticiaTO noticiaTO = detalle.get(position);
			
			LayoutInflater inflater = (LayoutInflater) 
					context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			
			View rowView = inflater.inflate(R.layout.listanoticia_content, 
										parent, false);
			
			ImageView imgLogo = (ImageView)rowView.findViewById(R.id.imageView1);
			TextView txtTitulo = (TextView)rowView.findViewById(R.id.txtTitulo);
			TextView txtNota = (TextView)rowView.findViewById(R.id.txtNota);
			
			txtTitulo.setText(Html.fromHtml(noticiaTO.titulo));
			txtNota.setText(Html.fromHtml(noticiaTO.notaCorta));
			
			//super.getView(position, convertView, parent);
			
			return rowView;
		}
		
		
		
	}
	
}
