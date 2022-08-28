package com.example.parkkaro;

public interface MyAsyncTask {
    Void doInBackground(String... urls);

    void onPostExecute(Void aVoid);
}
