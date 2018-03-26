package demo.marvellous.marvellous_kotlin.storage

import demo.marvellous.marvellous_kotlin.core.model.*
import demo.marvellous.marvellous_kotlin.core.model.Collection
import demo.marvellous.marvellous_kotlin.network.model.*

/**
 * Created by leslied on 21/03/2018.
 */
class StorageNetworkToCoreConverter {
    companion object {
//        //TODO convet the List converstions to using Generics.
//        inline fun <reified P> convertNetworkToCoreList(coreList: List<*>, clazz: Class<P>): List <P>? {
//
//            var networkModel = ArrayList<P>();
//
//            for(item  in coreList) {
//                networkModel.add(StorageNetworkToCoreConverter.convertNetworkToCore(item as? clazz. ));
//            }
//            return networkModel;
//        }

        fun convertNetworkToCoreComics(comics: List<NetworkComic>?): List<Comic> {

            var resultList = ArrayList<Comic>();

            for(item : NetworkComic in comics!!) {
                resultList.add(convertNetworkToCore(item));
            }

            return resultList;
        }

        fun convertNetworkToCore(comic: NetworkComic): Comic {

            return Comic(
                    comic.id,
                    comic.digitalId,
                    comic.title,
                    comic.issueNumber,
                    comic.variantDescription,
                    comic.description,
                    comic.modified,
                    comic.isbn,
                    comic.upc,
                    comic.diamondCode,
                    comic.ean,
                    comic.issn,
                    comic.format,
                    comic.pageCount,
                    convertNetworkToCorecoreTextObjects(comic.textObjects),
                    comic.resourceURI,
                    convertNetworkToCoreUrls(comic.urls),
                    convertNetworkToCore(comic.series),
                    convertNetworkToCoreVariants(comic.variants),
                    convertNetworkToCoreCollections(comic.collections),
                    convertNetworkToCoreCollectedIssues(comic.collectedIssues),
                    convertNetworkToCoreDates(comic.dates),
                    convertNetworkToCorePrices(comic.prices),
                    convertNetworkToCore(comic.thumbnail),
                    convertNetworkToCoreImages(comic.images),
                    convertNetworkToCore(comic.creators),
                    convertNetworkToCore(comic.characters),
                    convertNetworkToCore(comic.stories),
                    convertNetworkToCore(comic.events)
            )
        }

        fun convertNetworkToCore(characters: NetworkCharacters?): Characters {

            return Characters (characters?.available, characters?.returned, characters?.collectionURI,
                                convertNetworkToCoreCharacterItems(characters?.items));
        }


        private fun convertNetworkToCoreCollections(collections: List<NetworkCollection>?): List<Collection> {

            var resultList = ArrayList<Collection>();

            for(item : NetworkCollection in collections!!) {
                resultList.add(convertNetworkToCore(item));
            }

            return resultList;
        }

        fun convertNetworkToCore(characterItem: NetworkCharacterItem): CharacterItem {

            return CharacterItem(characterItem.resourceURI, characterItem.name, characterItem.role);
        }

        fun convertNetworkToCore(collection: NetworkCollection): Collection {

            return Collection(collection.resourceURI, collection.name);
        }

        private fun convertNetworkToCoreCharacterItems(characterItems: List<NetworkCharacterItem>?): List<CharacterItem> {

            var networkModel = ArrayList<CharacterItem>();

            for(characterItem : NetworkCharacterItem in characterItems!!) {
                networkModel.add(convertNetworkToCore(characterItem));
            }

            return networkModel;
        }

        fun convertNetworkToCore(collectedIssue: NetworkCollectedIssue): CollectedIssue {

            return CollectedIssue(collectedIssue.resourceURI, collectedIssue.name);
        }

        private fun convertNetworkToCoreCollectedIssues(collectedIssues: List<NetworkCollectedIssue>?): List<CollectedIssue> {

            var resultList = ArrayList<CollectedIssue>();

            for(item : NetworkCollectedIssue in collectedIssues!!) {
                resultList.add(convertNetworkToCore(item));
            }

            return resultList;
        }

        fun convertNetworkToCore(creators: NetworkCreators?): Creators {
            return Creators(creators?.available, creators?.returned, creators?.collectionURI,convertNetworkToCoreCreatorItems(creators?.items));
        }

        private fun convertNetworkToCoreCreatorItems(creatorItems: List<NetworkCreatorItem>?): List<CreatorItem> {

            var resultList = ArrayList<CreatorItem>();

            for(item : NetworkCreatorItem in creatorItems!!) {
                resultList.add(convertNetworkToCore(item));
            }
            return resultList;
         }

        fun convertNetworkToCore(creatorItem: NetworkCreatorItem): CreatorItem {
            return CreatorItem(creatorItem.resourceURI, creatorItem.name, creatorItem.role);
        }

        fun convertNetworkToCore(date: NetworkDate): Date {
            return Date(date.type, date.date);
        }

        private fun convertNetworkToCoreDates(dates: List<NetworkDate>?): List<Date> {
            var resultList = ArrayList<Date>();

            for(item : NetworkDate in dates!!) {
                resultList.add(convertNetworkToCore(item));
            }

            return resultList;
        }

        fun convertNetworkToCore(events: NetworkEvents?): Events {
            return Events(events?.available, events?.returned, events?.collectionURI, convertNetworkToCoreEventItems(events?.items))
        }

        private fun convertNetworkToCoreEventItems(eventItems: List<NetworkEventItem>?): List<EventItem> {

            var resultList = ArrayList<EventItem>();

            for(item : NetworkEventItem in eventItems!!) {
                resultList.add(convertNetworkToCore(item));
            }

            return resultList;
        }

        fun convertNetworkToCore(eventItem: NetworkEventItem): EventItem {

            return EventItem(eventItem.resourceURI, eventItem.name);
        }

        fun convertNetworkToCore(image: NetworkImage?):Image  {

            return Image(image?.path, image?.extension)
        }

        private fun convertNetworkToCoreImages(images: List<NetworkImage>?): List<Image> {

            var resultList = ArrayList<Image>();

            for(item : NetworkImage in images!!) {
                resultList.add(convertNetworkToCore(item));
            }

            return resultList;
        }

        fun convertNetworkToCore(price: NetworkPrice): Price {
            return Price(price.type, price.price)
        }

        private fun convertNetworkToCorePrices(prices: List<NetworkPrice>?): List<Price> {

            var resultList = ArrayList<Price>();

            for(item : NetworkPrice in prices!!) {
                resultList.add(convertNetworkToCore(item));
            }

            return resultList;
        }

        fun convertNetworkToCore(series: NetworkSeries?): Series {
            return Series(series?.resourceURI,series?.name);
        }

        private fun convertNetworkToCoreSeries(series: List<NetworkSeries>?): List<Series> {

            var resultList = ArrayList<Series>();

            for(item : NetworkSeries in series!!) {
                resultList.add(convertNetworkToCore(item));
            }

            return resultList;
        }

        fun convertNetworkToCore(stories: NetworkStories?): Stories {

            return Stories( stories?.available,
                            stories?.returned,
                            stories?.collectionURI,
                            convertNetworkToCoreStoryItems(stories?.items));
        }

        private fun convertNetworkToCoreStoryItems(storyItems: List<NetworkStoryItem>?): List<StoryItem> {

            var resultList = ArrayList<StoryItem>();

            for(item : NetworkStoryItem in storyItems!!) {
                resultList.add(convertNetworkToCore(item));
            }

            return resultList;
        }

        fun convertNetworkToCore(storyItem: NetworkStoryItem): StoryItem {
            return StoryItem(storyItem.resourceURI,storyItem.name, storyItem.type);
        }

        fun convertNetworkToCore(inTextObject: NetworkTextObject): TextObject {
           return TextObject(inTextObject.type, inTextObject.language, inTextObject.text);
        }

        private fun convertNetworkToCorecoreTextObjects(inTextObject: List<NetworkTextObject>?): List<TextObject> {
            var resultList = ArrayList<TextObject>();

            for(item : NetworkTextObject in inTextObject!!) {
                resultList.add(convertNetworkToCore(item));
            }

            return resultList;
        }

        fun convertNetworkToCore(inThumbnail: NetworkThumbnail?): Thumbnail {
            return Thumbnail(inThumbnail?.path, inThumbnail?.extension);
        }

        fun convertNetworkToCore(inVariant: NetworkVariant): Variant {

            return Variant(inVariant.resourceURI, inVariant.name);
        }

        private fun convertNetworkToCoreVariants(inVariants: List<NetworkVariant>?): List<Variant> {

            var resultList = ArrayList<Variant>();

            for(item : NetworkVariant in inVariants!!) {
                resultList.add(convertNetworkToCore(item));
            }

            return resultList;
        }

        fun convertNetworkToCore(inUrl: NetworkUrl): Url {

            return Url(inUrl.type, inUrl.url);
        }

        private fun convertNetworkToCoreUrls(inUrls: List<NetworkUrl>?): List<Url> {

            var resultList = ArrayList<Url>();

            for(item : NetworkUrl in inUrls!!) {
                resultList.add(convertNetworkToCore(item));
            }

            return resultList;
        }

    }
}