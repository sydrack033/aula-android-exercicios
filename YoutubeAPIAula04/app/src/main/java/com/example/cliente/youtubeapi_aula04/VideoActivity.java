package com.example.cliente.youtubeapi_aula04;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class VideoActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener,YouTubePlayer.PlaybackEventListener{

    String chaveYoutube = "AIzaSyC9-qRReaOvnXgwl0aPH2UkWESgUCN46Zw";
    YouTubePlayerView youTubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        youTubePlayerView=(YouTubePlayerView)findViewById(R.id.youtube_view);
        youTubePlayerView.initialize(chaveYoutube, this);
    }

    public void exitActivity(View view){
        finish();
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean foiRestaurado) {

        if (!foiRestaurado){

            Intent intent = getIntent();
            String link = intent.getStringExtra("link");
            String chaveVideo = link.substring(link.length()-11);
            youTubePlayer.cueVideo(chaveVideo);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

        if (youTubeInitializationResult.isUserRecoverableError()){
            youTubeInitializationResult.getErrorDialog(this,1).show();
        }else {
            String erro="Erro ao inicializar o Youtube"+youTubeInitializationResult.toString();

            Toast.makeText(getApplication(),erro,Toast.LENGTH_LONG).show();
        }
    }

    protected void onActivityResult(int RequestCode, int resultcode, Intent data){

        if(resultcode==1){
            getYoutubePlayerProvider().initialize(chaveYoutube,this);
        }
    }

    protected YouTubePlayer.Provider getYoutubePlayerProvider(){
        return youTubePlayerView;
    }

    @Override
    public void onPlaying() {

    }

    @Override
    public void onPaused() {

    }

    @Override
    public void onStopped() {

    }

    @Override
    public void onBuffering(boolean b) {

    }

    @Override
    public void onSeekTo(int i) {

    }
}