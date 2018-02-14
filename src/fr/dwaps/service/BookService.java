package fr.dwaps.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.google.gson.Gson;

import fr.dwaps.model.beans.Book;

public final class BookService {
	private BookService() {}
	
	private static String WS_BASEURL = "http://ws.limoissa.fr:3333/books";
	
	@SuppressWarnings("unchecked")
	public static List<Book> findAll() {
		List<Book> books = null;
		
		try {
			URL url = new URL(WS_BASEURL);
			HttpURLConnection cnx = (HttpURLConnection) url.openConnection();
			
			try (InputStream is = cnx.getInputStream()) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(is));
				
				String line = reader.readLine();
				while (line != null) {
					books = (List<Book>) new Gson().fromJson(line, Object.class);
					if (books != null) break;
					line = reader.readLine();
				}
				
				cnx.disconnect();
			}
		}
		catch (Exception e) { e.printStackTrace(); }
		
		return books;
	}
	
	public static Book find(int id) {
		Book book = null;
		
		try {
			URL url = new URL(WS_BASEURL + "/detail?id=" + id);
			HttpURLConnection cnx = (HttpURLConnection) url.openConnection();
			
			try (InputStream is = cnx.getInputStream()) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(is));
				
				String line = reader.readLine();
				while (line != null) {
					book = (Book) new Gson().fromJson(line, Book.class);
					if (book != null) break;
					line = reader.readLine();
				}
			}
			cnx.disconnect();
		}
		catch (Exception e) { e.printStackTrace(); }
		
		return book;
	}
	
	public static void create(Book book) {
		try {
			URL url = new URL(WS_BASEURL + "/create");
			HttpURLConnection cnx = (HttpURLConnection) url.openConnection();
			
			cnx.setDoOutput(true);
			cnx.setRequestMethod("POST");
			ObjectOutputStream out = new ObjectOutputStream(cnx.getOutputStream());
			out.writeObject(book);
			
			cnx.getInputStream();
			cnx.disconnect();
		}
		catch (Exception e) { e.printStackTrace(); }
	}
	
	public static void update(Book book) {
		try {
			URL url = new URL(WS_BASEURL + "/update?id=" + book.getId());
			HttpURLConnection cnx = (HttpURLConnection) url.openConnection();
			
			cnx.setDoOutput(true);
			cnx.setRequestMethod("PUT");
			ObjectOutputStream out = new ObjectOutputStream(cnx.getOutputStream());
			out.writeObject(book);
			
			cnx.getInputStream();
			cnx.disconnect();
		}
		catch (Exception e) { e.printStackTrace(); }
	}
	
	public static void delete(int id) {
		try {
			URL url = new URL(WS_BASEURL + "/delete?id=" + id);
			HttpURLConnection cnx = (HttpURLConnection) url.openConnection();
			cnx.setRequestMethod("DELETE");
			cnx.getInputStream();
		}
		catch (Exception e) { e.printStackTrace(); }
	}
}
