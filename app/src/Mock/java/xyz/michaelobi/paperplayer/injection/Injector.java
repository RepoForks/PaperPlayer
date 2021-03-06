package xyz.michaelobi.paperplayer.injection;

import android.content.Context;

import xyz.michaelobi.paperplayer.data.MusicRepository;
import xyz.michaelobi.paperplayer.data.MusicRepositoryInterface;
import xyz.michaelobi.paperplayer.data.library.LibraryManager;
import xyz.michaelobi.paperplayer.data.library.local.MockLocalLibraryManager;
import xyz.michaelobi.paperplayer.event.EventBus;
import xyz.michaelobi.paperplayer.event.RxBus;
import xyz.michaelobi.paperplayer.playback.queue.LocalQueueManager;
import xyz.michaelobi.paperplayer.playback.queue.QueueManager;

/**
 * PaperPlayer
 * Michael Obi
 * 23 10 2016 10:36 AM
 */

public class Injector {

    public static EventBus eventBus;

    public static EventBus provideEventBus() {
        if (eventBus == null) {
            eventBus = new RxBus();
        }

        return eventBus;
    }

    public static QueueManager provideQueueManager() {
        return new LocalQueueManager();
    }

    public static MusicRepositoryInterface provideMusicRepository(Context context) {
        return new MusicRepository(provideLibraryManager(context));
    }

    public static LibraryManager provideLibraryManager(Context context) {
        return new MockLocalLibraryManager();
    }
}
