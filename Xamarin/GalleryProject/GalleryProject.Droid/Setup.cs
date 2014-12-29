using Android.Content;
using Android.Graphics;
using Cirrious.CrossCore;
using Cirrious.CrossCore.Platform;
using Cirrious.MvvmCross.Droid.Platform;
using Cirrious.MvvmCross.Plugins.DownloadCache;
using Cirrious.MvvmCross.Plugins.DownloadCache.Droid;
using Cirrious.MvvmCross.ViewModels;
using GalleryProject.Droid.DownloadCache;

namespace GalleryProject.Droid
{
    public class Setup : MvxAndroidSetup
    {
        public Setup(Context applicationContext) : base(applicationContext)
        {
        }

        protected override IMvxApplication CreateApp()
        {
            // Override DownloadCache Singleton
            Mvx.RegisterSingleton<IMvxImageCache<Bitmap>>(() => CreateCache());
            return new Core.App();
        }

        private BsImageCache<Bitmap> CreateCache()
        {
            var configuration = MvxDownloadCacheConfiguration.Default;

            var fileDownloadCache = new MvxFileDownloadCache(configuration.CacheName,
                                                             configuration.CacheFolderPath,
                                                             configuration.MaxFiles,
                                                             configuration.MaxFileAge);
            return new BsImageCache<Bitmap>(fileDownloadCache, configuration.MaxInMemoryFiles, configuration.MaxInMemoryBytes);
        }
		
        protected override IMvxTrace CreateDebugTrace()
        {
            return new DebugTrace();
        }
    }
}