package demo.marvellous.marvellous_kotlin.storage

import demo.marvellous.marvellous_kotlin.core.model.*
import demo.marvellous.marvellous_kotlin.core.model.Collection
import demo.marvellous.marvellous_kotlin.network.model.*

/**
 * Created by leslied on 20/03/2018.
 */
class StorageCoreToNetworkConverter {
    companion object {

        fun convertCoreToNetwork(coreComic: Comic): NetworkComic {

            var networkModel = NetworkComic()

            networkModel.id = coreComic.id
            networkModel.digitalId = coreComic.digitalId
            networkModel.title = coreComic.title
            networkModel.issueNumber = coreComic.issueNumber
            networkModel.variantDescription = coreComic.variantDescription
            networkModel.description = coreComic.description
            networkModel.modified = coreComic.modified
            networkModel.isbn = coreComic.isbn
            networkModel.upc = coreComic.upc
            networkModel.diamondCode = coreComic.diamondCode
            networkModel.ean = coreComic.ean
            networkModel.issn = coreComic.issn
            networkModel.format = coreComic.format
            networkModel.pageCount = coreComic.pageCount
            networkModel.resourceURI = coreComic.resourceURI
            networkModel.format = coreComic.format


            networkModel.urls = convertCoreToNetworkUrls(coreComic.urls)
            networkModel.series = convertCoreToNetwork(coreComic.series);
            networkModel.stories = convertCoreToNetwork(coreComic.stories);
            networkModel.textObjects = convertCoreToNetworkcoreTextObjects(coreComic.textObjects);
            networkModel.characters = convertCoreToNetwork(coreComic.characters)
            networkModel.collectedIssues = convertCoreToNetworkCollectedIssues(coreComic.collectedIssues)
            networkModel.collections = convertCoreToNetworkCollections(coreComic.collections)
            networkModel.creators = convertCoreToNetwork(coreComic.creators)
            networkModel.dates = convertCoreToNetworkDates(coreComic.dates)
            networkModel.events = convertCoreToNetwork(coreComic.events)
            networkModel.stories = convertCoreToNetwork(coreComic.stories)
            networkModel.thumbnail = convertCoreToNetwork(coreComic.thumbnail)
            networkModel.images = convertCoreToNetworkImages(coreComic.images)
            networkModel.variants = convertCoreToNetworkVariants(coreComic.variants)
            networkModel.prices = convertCoreToNetworkPrices(coreComic.prices)

            return networkModel;
        }

        fun convertCoreToNetwork(coreCharacters: Characters?): NetworkCharacters {

            var networkModel = NetworkCharacters();

            networkModel.available = coreCharacters!!.available;
            networkModel.collectionURI = coreCharacters.collectionURI;
            networkModel.returned = coreCharacters.returned;
            networkModel.items = convertCoreToNetworkCharacterItems(coreCharacters.items);

            return networkModel;
        }

//TODO convet the List converstions to using Generics.
//        fun <P, T> convertCoreToNetworkList(coreList: List<T>, clazz: Class<P>): List<P>? {
//            var networkModel = ArrayList<P>();
//
//            for(item : T in coreList!!) {
//                networkModel.add(convertCoreToNetwork(item));
//            }
//            return networkModel;
//        }

        private fun convertCoreToNetworkCollections(coreCollections: List<Collection>?): List<NetworkCollection> {

            var networkModel = ArrayList<NetworkCollection>();

            for(collection : Collection in coreCollections!!) {
                networkModel.add(convertCoreToNetwork(collection));
            }

            return networkModel;
        }

        fun convertCoreToNetwork(coreCharacterItem: CharacterItem): NetworkCharacterItem {

            var networkModel = NetworkCharacterItem();

            networkModel.name = coreCharacterItem.name
            networkModel.resourceURI = coreCharacterItem.resourceURI
            networkModel.role = coreCharacterItem.resourceURI

            return networkModel;
        }

        fun convertCoreToNetwork(coreCollection: Collection): NetworkCollection {

            var networkModel = NetworkCollection();

            networkModel.name = coreCollection.name
            networkModel.resourceURI = coreCollection.resourceURI

            return networkModel;
        }

        private fun convertCoreToNetworkCharacterItems(coreCharacterItems: List<CharacterItem>?): List<NetworkCharacterItem> {

            var networkModel = ArrayList<NetworkCharacterItem>();

            for(characterItem : CharacterItem in coreCharacterItems!!) {
                networkModel.add(convertCoreToNetwork(characterItem));
            }

            return networkModel;
        }

        fun convertCoreToNetwork(coreCollectedIssue: CollectedIssue): NetworkCollectedIssue {

            var networkModel = NetworkCollectedIssue();

            networkModel.name = coreCollectedIssue.name
            networkModel.resourceURI = coreCollectedIssue.resourceURI

            return networkModel;
        }

        private fun convertCoreToNetworkCollectedIssues(coreCollectedIssues: List<CollectedIssue>?): List<NetworkCollectedIssue> {

            var networkModel = ArrayList<NetworkCollectedIssue>();

            for(coreCollectedIssue : CollectedIssue in coreCollectedIssues!!) {
                networkModel.add(convertCoreToNetwork(coreCollectedIssue));
            }

            return networkModel;
        }

        fun convertCoreToNetwork(coreCreators: Creators?): NetworkCreators {

            var networkModel = NetworkCreators();

            networkModel.available = coreCreators!!.available;
            networkModel.collectionURI = coreCreators.collectionURI;
            networkModel.returned = coreCreators.returned;
            networkModel.items = convertCoreToNetworkCreatorItems(coreCreators.items);

            return networkModel;
        }

        private fun convertCoreToNetworkCreatorItems(coreCreatorItems: List<CreatorItem>?): List<NetworkCreatorItem> {

            var networkModel = ArrayList<NetworkCreatorItem>();

            for(creatorItem : CreatorItem in coreCreatorItems!!) {
                networkModel.add(convertCoreToNetwork(creatorItem));
            }

            return networkModel;
        }

        fun convertCoreToNetwork(coreCreatorItem: CreatorItem): NetworkCreatorItem {

            var networkModel = NetworkCreatorItem();

            networkModel.name = coreCreatorItem.name
            networkModel.resourceURI = coreCreatorItem.resourceURI
            networkModel.role = coreCreatorItem.role

            return networkModel;
        }

        fun convertCoreToNetwork(coreDate: Date): NetworkDate {

            var networkModel = NetworkDate();

            networkModel.date = coreDate.date;
            networkModel.type = coreDate.type;

            return networkModel;
        }

        private fun convertCoreToNetworkDates(coreDates: List<Date>?): List<NetworkDate> {

            var networkModel = ArrayList<NetworkDate>();

            for(date : Date in coreDates!!) {
                networkModel.add(convertCoreToNetwork(date));
            }
            return networkModel;
        }

        fun convertCoreToNetwork(coreEvents: Events?): NetworkEvents {

            var networkModel = NetworkEvents();

            networkModel.available = coreEvents!!.available;
            networkModel.collectionURI = coreEvents.collectionURI;
            networkModel.returned = coreEvents.returned;
            networkModel.items = convertCoreToNetworkEventItems(coreEvents.items);

            return networkModel;
        }

        private fun convertCoreToNetworkEventItems(coreEventItems: List<EventItem>?): List<NetworkEventItem> {

            var networkModel = ArrayList<NetworkEventItem>();

            for(eventItem : EventItem in coreEventItems!!) {
                networkModel.add(convertCoreToNetwork(eventItem));
            }

            return networkModel;
        }

        fun convertCoreToNetwork(coreEventItem: EventItem): NetworkEventItem {

            var networkModel = NetworkEventItem();

            networkModel.name = coreEventItem.name;
            networkModel.resourceURI = coreEventItem.resourceURI;

            return networkModel;
        }

        fun convertCoreToNetwork(coreImage: Image?): NetworkImage {

            var networkModel = NetworkImage();
            networkModel.extension = coreImage!!.extension;
            networkModel.path = coreImage.path;

            return networkModel;
        }

        private fun convertCoreToNetworkImages(coreImages: List<Image>?): List<NetworkImage> {

            var networkModel = ArrayList<NetworkImage>();

            for(item : Image in coreImages!!) {
                networkModel.add(convertCoreToNetwork(item));
            }

            return networkModel;
        }

        fun convertCoreToNetwork(corePrice: Price): NetworkPrice {

            var networkModel = NetworkPrice();
            networkModel.price = corePrice.price;
            networkModel.type = corePrice.type;

            return networkModel;
        }

        private fun convertCoreToNetworkPrices(corePrices: List<Price>?): List<NetworkPrice> {

            var networkModel = ArrayList<NetworkPrice>();

            for(item : Price in corePrices!!) {
                networkModel.add(convertCoreToNetwork(item));
            }

            return networkModel;
        }

        fun convertCoreToNetwork(coreSeries: Series?): NetworkSeries {

            var networkModel = NetworkSeries();

            networkModel.name = coreSeries!!.name;
            networkModel.resourceURI = coreSeries.resourceURI;

            return networkModel;
        }

        private fun convertCoreToNetworkSeries(coreSeries: List<Series>?): List<NetworkSeries> {

            var networkModel = ArrayList<NetworkSeries>();

            for(item : Series in coreSeries!!) {
                networkModel.add(convertCoreToNetwork(item));
            }

            return networkModel;
        }

        fun convertCoreToNetwork(coreStories: Stories?): NetworkStories {

            var networkModel = NetworkStories();

            networkModel.returned = coreStories!!.returned;
            networkModel.collectionURI = coreStories.collectionURI;
            networkModel.available = coreStories.available;
            networkModel.items = convertCoreToNetworkStoryItems(coreStories.items);
            return networkModel;
        }

        private fun convertCoreToNetworkStoryItems(coreStoryItems: List<StoryItem>?): List<NetworkStoryItem> {

            var networkModel = ArrayList<NetworkStoryItem>();

            for(storyItem : StoryItem in coreStoryItems!!) {
                networkModel.add(convertCoreToNetwork(storyItem));
            }

            return networkModel;
        }

        fun convertCoreToNetwork(coreStoryItem: StoryItem): NetworkStoryItem {

            var networkModel = NetworkStoryItem();

            networkModel.name = coreStoryItem.name;
            networkModel.resourceURI = coreStoryItem.resourceURI;
            networkModel.type = coreStoryItem.type;

            return networkModel;
        }

        fun convertCoreToNetwork(coreTextObject: TextObject): NetworkTextObject {

            var networkModel = NetworkTextObject();

            networkModel.language = coreTextObject.language;
            networkModel.text = coreTextObject.text;
            networkModel.type = coreTextObject.type;

            return networkModel;
        }

        private fun convertCoreToNetworkcoreTextObjects(coreTextObject: List<TextObject>?): List<NetworkTextObject> {

            var networkModel = ArrayList<NetworkTextObject>();

            for(item : TextObject in coreTextObject!!) {
                networkModel.add(convertCoreToNetwork(item));
            }

            return networkModel;
        }

        fun convertCoreToNetwork(coreThumbnail: Thumbnail?): NetworkThumbnail {

            var networkModel = NetworkThumbnail();

            networkModel.extension = coreThumbnail!!.extension;
            networkModel.path = coreThumbnail.path;

            return networkModel;
        }

        fun convertCoreToNetwork(coreVariant: Variant): NetworkVariant {

            var networkVariant = NetworkVariant();

            networkVariant.name = coreVariant.name;
            networkVariant.resourceURI = coreVariant.resourceURI;

            return networkVariant;
        }

        private fun convertCoreToNetworkVariants(coreVariants: List<Variant>?): List<NetworkVariant> {

            var networkModel = ArrayList<NetworkVariant>();

            for(item : Variant in coreVariants!!) {
                networkModel.add(convertCoreToNetwork(item));
            }

            return networkModel;
        }

        fun convertCoreToNetwork(coreUrl: Url): NetworkUrl {

            var networkModel = NetworkUrl();

            networkModel.type = coreUrl.type;
            networkModel.url = coreUrl.url;
            return networkModel;
        }

        private fun convertCoreToNetworkUrls(coreUrls: List<Url>?): List<NetworkUrl> {

            var networkModel = ArrayList<NetworkUrl>();

            for(item : Url in coreUrls!!) {
                networkModel.add(convertCoreToNetwork(item));
            }

            return networkModel;
        }

    }

}